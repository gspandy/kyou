package net.nuclearg.kyou.pack.matcher.filter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 表示一个类是{@link FilterMatcher}
 * 
 * @author ng
 * 
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@interface FilterDescription {
    public String value();
}
