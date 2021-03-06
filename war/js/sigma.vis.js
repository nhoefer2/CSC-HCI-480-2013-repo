function init(canvas, json, depth, leaves) {
  // Instanciate sigma.js and customize rendering :
  console.log("canvas id: " + canvas);
  console.log("json: " + json);
  console.log("depth: " + depth);
  console.log("leaves: " + leaves);

  var minNS = 0;
  var maxNS = 0;
  var maxR = 0;
  var lth = 0;

  if(depth <= 10){
    minNS = .5;
    maxNS = 3;
    maxR = 16
    lth = 6;
  }
  else if(depth <= 45){
    minNS = .5;
    maxNS = 1;
    maxR = 32
    lth = 3
  }
  else{
    minNS = .05;
    maxNS = .1;
    maxR = 1240;
    lth = 1;
  }

  var sigInst = sigma.init(document.getElementById(canvas)).drawingProperties({
    edgeColor: '000',
    labelThreshold: lth,
    //defaultEdgeType: 'curve',
    defaultLabelColor: '#fff'
  }).graphProperties({
    minNodeSize: minNS,
    maxNodeSize: maxNS,
    minEdgeSize: 2,
    maxEdgeSize: 3
  }).mouseProperties({
    maxRatio: maxR
  });

  var tempI = 0;
  var leafCount = 0;
  var nodeScale = 0.01;
  var leafID;
  var nodeID;

  function traverse(parent, node, level, index){

    //Print node to console (leaf)
    if (node.label !== null) {
      console.log(node.label);
    }
    else {  //Print node to console (internal)
      console.log(node.field + " " + node.condition + " " + node.value);
    }

    //Create node (leaf)
    if (node.label !== null){
      //Construct ID, increment leafCount
      leafID = "l-"+node.label+leafCount+"-l";
      leafCount++;
      //Add node
      sigInst.addNode(leafID, {
        label: node.label,
        x: node.indexDispX*nodeScale,
        y: node.levelDispY*nodeScale,
        color: '#9de24f'
      });
      console.log(leafID);
    }
    //Create node (internal)
    else {
      //Construct ID
      nodeID = "n-"+node.indexDispX+"-"+node.levelDispY+"-n";
      //Add node
      sigInst.addNode( nodeID, {
        label: node.field + " " + node.condition + " " + node.value,
        x: node.indexDispX*nodeScale,
        y: node.levelDispY*nodeScale,
        color: '#5ac3b6'
      });
      console.log(nodeID);
    }

    //Create edge
    if(parent != null){
      if(node.label !== null){
        var parentID = "n-"+parent.indexDispX+"-"+parent.levelDispY+"-n";
        var edgeID = parentID + "-e-" + leafID;
        console.log("LEdge: "+edgeID);
        sigInst.addEdge(edgeID,parentID,leafID);
      }
      else{
        var parentID = "n-"+parent.indexDispX+"-"+parent.levelDispY+"-n";
        var edgeID = parentID+ "-e-" + nodeID;
        console.log("NEdge: "+edgeID);
        sigInst.addEdge(edgeID,parentID,nodeID);
      }
    }

    if (node.children !== null) {
      for (var i = 0; i < node.children.length; i++) {
        if(i == 0){
          traverse(node,node.children[i],level+1,index-1);
        }
        else if (i == 1){
          traverse(node,node.children[i],level+1,index+1);
        }
      }
    }
  }

  function setLevelIndex(node){
    tempI = 0;
    setLI(node,0);
  }

  function setLI(node, level){
    if(node != null){

      node.levelDispY = level;

      if(node.children !== null){

        level++;

        setLI(node.children[0],level);
      }

      node.indexDispX = tempI;

     tempI++;

     if(node.children !== null){
        setLI(node.children[1],level);
     }
    }
  }


  // var tree = {field:"petal_len",condition:"<=",value:2.45,
  //   children:[{label:"Iris-setosa"},{field:"petal_wid",condition:"<=",value:1.6500001,
  //     children:[{field:"sepal_len",condition:"<=",value:5.95,
  //       children:[{label:"Iris-virginica"},{field:"petal_wid",condition:"<=",value:1.8499999,
  //         children:[{field:"petal_len",condition:"<=",value:4.55,
  //           children:[{label:"Iris-virginica"},{label:"Iris-versicolor"}]},

  //   {label:"Iris-virginica"}]}]},{field:"petal_len",condition:"<=",value:4.95,
  //     children:[{label:"Iris-versicolor"},{field:"sepal_len",condition:"<=",value:6.05,
  //       children:[{label:"Iris-virginica"},{label:"Iris-versicolor"}]}]}]}]};


  var tree = jQuery.parseJSON(json);

  setLevelIndex(tree);
  traverse(null,tree,0,0);

  // Draw the graph :
  sigInst.draw();
}


//if (document.addEventListener) {
//  document.addEventListener("DOMContentLoaded", init, false);
//} else {
//  window.onload = init;
//}
