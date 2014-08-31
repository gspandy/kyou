package net.nuclearg.kyou.pack.expr;

import net.nuclearg.kyou.pack.Expr.ExprDescription;
import net.nuclearg.kyou.pack.Expr.ExprDescription.ExprPostfix;
import net.nuclearg.kyou.pack.Expr;
import net.nuclearg.kyou.pack.PackContext;
import net.nuclearg.kyou.util.value.Value;
import net.nuclearg.kyou.util.value.ValueType;

/**
 * 求报文元素的某个属性的值
 * 
 * @author ng
 * 
 */
@ExprDescription(name = "a", postfix = ExprPostfix.String, typeIn = ValueType.Dom, typeOut = ValueType.String)
public class AttributeExpr extends Expr {

    @Override
    protected Value eval(Value input, PackContext context) {
        return new Value(input.domValue.attr(this.postfix));
    }

}