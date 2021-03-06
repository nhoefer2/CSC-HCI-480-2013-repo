package edu.oswego.csc480_hci521_2013.shared.h2o.urlbuilders;

/**
 *
 */
public class RFBuilder extends AbstractBuilder
{

    RFBuilder()
    {
    }

    public RFBuilder(String dataKey)
    {
        super("RF.json");
        addArg("data_key", dataKey);
    }

    // TODO: add validation to the setters where possible

    /**
     * @param value Column name	The output classification (also known as 'response variable') that is being learned.
     * @return
     */
    public RFBuilder setResponseVariable(String value)
    {
        addArg("response_variable", value);
        return this;
    }

    /**
     * @param value Integer from 0 to 2147483647
     * @return
     */
    public RFBuilder setNtree(Integer value)
    {
        addArg("ntree", value.toString());
        return this;
    }

    /**
     * @param value use gini statistic (otherwise entropy is used)
     * @return
     */
    public RFBuilder setGini(boolean value)
    {
        addArg("gini", value ? "1" : "0");
        return this;
    }

// TODO: figure out the format for this argument... is it just a multi-select?
//    /**
//     * @param value Category weight (positive)
//     * @return
//     */
//    public RFBuilder setClassWeights(boolean value)
//    {
//        addArg("class_weights", value);
//        return this;
//    }

    /**
     * @param value Use Stratified sampling
     * @return
     */
    public RFBuilder setStratify(boolean value)
    {
        addArg("stratify", value ? "1" : "0");
        return this;
    }

// TODO: figure out the format for this argument... is it just a multi-select?
//    /**
//     * @param value Category strata (integer)
//     * @return
//     */
//    public RFBuilder setStrata(boolean value)
//    {
//        addArg("strata", value);
//        return this;
//    }

    /**
     * @param value Valid H2O key
     * @return
     */
    public RFBuilder setModelKey(String value)
    {
        addArg("model_key", value);
        return this;
    }

    /**
     * @param value Out of bag errors
     * @return
     */
    public RFBuilder setOutOfBagErrorEstimate(boolean value)
    {
        addArg("out_of_bag_error_estimate", value ? "1" : "0");
        return this;
    }

    /**
     * @param value Integer from 0 to 2147483647
     * @return
     */
    public RFBuilder setFeatures(Integer value)
    {
        addArg("features", value.toString());
        return this;
    }

    /**
     * can be used multiple times
     * @param value Columns to select
     * @return
     */
    public RFBuilder setIgnore(Integer value)
    {
        addMultiArg("ignore", value.toString());
        return this;
    }

    /**
     * @param value Integer from 1 to 100
     * @return
     */
    public RFBuilder setSample(Integer value)
    {
        addArg("sample", value.toString());
        return this;
    }

    /**
     * @param value Integer from 0 to 65535
     * @return
     */
    public RFBuilder setBinLimit(Integer value)
    {
        addArg("bin_limit", value.toString());
        return this;
    }

    /**
     * @param value Integer from 0 to 2147483647
     * @return
     */
    public RFBuilder setDepth(Integer value)
    {
        addArg("depth", value.toString());
        return this;
    }

    /**
     * @param value Integer value
     * @return
     */
    public RFBuilder setSeed(Integer value)
    {
        addArg("seed", value.toString());
        return this;
    }

    /**
     * @param value Build trees in parallel
     * @return
     */
    public RFBuilder setParallel(boolean value)
    {
        addArg("parallel", value ? "1" : "0");
        return this;
    }

    /**
     * @param value Integer from 0 to 2147483647
     * @return
     */
    public RFBuilder setExclusiveSplitLimit(Integer value)
    {
        addArg("exclusive_split_limit", value.toString());
        return this;
    }
}
