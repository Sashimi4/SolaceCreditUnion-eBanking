package com.company.solace.data.security;

import org.springframework.security.web.savedrequest.HttpSessionRequestCache;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  Class for caching requests. It can contain custom Request caches
 */
class CustomRequestCache extends HttpSessionRequestCache {

    /**
     * Saves a given HTTP request made by saving its corresponding request type and response.
     *
     * @param request       Request type (in our case POST)
     * @param response      HTTP Response from 100 to 500
     */
    @Override
    public void saveRequest(HttpServletRequest request, HttpServletResponse response) {
        if (!SecurityUtils.isFrameworkInternalRequest(request)) {
            super.saveRequest(request, response);
        }
    }
}
