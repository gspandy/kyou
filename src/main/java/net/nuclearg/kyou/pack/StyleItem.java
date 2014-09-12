package net.nuclearg.kyou.pack;

import java.util.List;

import net.nuclearg.kyou.KyouException;
import net.nuclearg.kyou.pack.matcher.Matcher;
import net.nuclearg.kyou.util.XmlUtils;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;

/**
 * 报文组包样式单元
 * <p>
 * 组包样式单元描述了对于某一类元素的组包方式
 * </p>
 * 
 * @author ng
 */
class StyleItem {
    /**
     * 该组包样式单元隶属于的组包样式
     */
    public final KyouPackStyle style;

    /**
     * 该组包样式单元适用于的元素
     */
    final Matcher target;
    /**
     * 段列表
     */
    final List<StyleFormatSegment> segments;

    StyleItem(Element e, KyouPackStyle style) {
        this.style = style;

        /*
         * <pre>
         * <style target="...">
         * <format><![CDATA[<%>%</%>]]></format>
         * <param>b2s n</s>
         * <param>m</s>
         * <param>b2s n</s>
         * </style>
         * </pre>
         */

        // 初始化target
        String target = XmlUtils.selectText(e, "@target");
        if (StringUtils.isEmpty(target))
            throw new KyouException("targat is empty");
        try {
            this.target = Matcher.parse(target);
        } catch (Exception ex) {
            throw new KyouException("target syntax error. target: " + target, ex);
        }

        // 读取format
        String format = XmlUtils.selectText(e, "format");

        // 读取用户定义的参数
        List<String> params = XmlUtils.selectTextList(e, "param");

        // 初始化segments
        try {
            this.segments = StyleFormatSegment.parseFormatString(format, style.config.encoding, params);
        } catch (Exception ex) {
            throw new KyouException("expr syntax error.  target: " + target, ex);
        }
    }
}
