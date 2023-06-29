package reingold.paz.graphql.datasource.specification;

import java.text.MessageFormat;

public abstract class BaseSpecification {

    protected static String contains(String keyword) {
        return MessageFormat.format("%{0}%", keyword);
    }
}
