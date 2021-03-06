package edu.oswego.csc480_hci521_2013.shared.h2o.urlbuilders;

import edu.oswego.csc480_hci521_2013.shared.h2o.json.ResponseStatus;
import java.util.Map.Entry;

/**
 *
 */
public class RedirectRequestBuilder extends AbstractBuilder
{

    RedirectRequestBuilder()
    {
    }

    public RedirectRequestBuilder(ResponseStatus status)
    {
        super(status.getRedirectRequest());

        if (!status.isRedirect()) {
            throw new IllegalArgumentException("not a redirect");
        }
        for (Entry<String, String> arg: status.getRedirectRequestArgs().entrySet()) {
            addArg(arg.getKey(), arg.getValue());
        }
    }
}
