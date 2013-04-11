package org.mayocat.shop.payment;

import java.util.Map;

/**
 * @version $Id$
 */
public final class PaymentResponse
{
    private Map<String, Object> data;

    private boolean isSuccessful;

    private String redirectURL;

    private boolean isRedirect = false;

    public PaymentResponse(boolean isSuccessful, Map<String, Object> data)
    {
        this.isSuccessful = isSuccessful;
        this.data = data;
    }

    public Map<String, Object> getData()
    {
        return data;
    }

    public boolean isSuccessful()
    {
        return isSuccessful;
    }

    public String getRedirectURL()
    {
        return redirectURL;
    }

    public void setRedirectURL(String redirectURL)
    {
        this.redirectURL = redirectURL;
    }

    public boolean isRedirect()
    {
        return isRedirect;
    }

    public void setRedirect(boolean redirect)
    {
        isRedirect = redirect;
    }
}
