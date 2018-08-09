package net.dzikoysk.reposilite.utils;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.servlet.HandlerMapping;

public final class RequestUtils {

    private static final AntPathMatcher ANT_MATCHER = new AntPathMatcher();

    public static String extractWildcard(HttpServletRequest request) {
        return extractWildcard(ANT_MATCHER, request);
    }

    public static String extractWildcard(PathMatcher matcher, HttpServletRequest request) {
        String path = request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE).toString();
        String bestMatchingPattern = request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE).toString();

        return matcher.extractPathWithinPattern(bestMatchingPattern, path);
    }

    private RequestUtils() {  }

}
