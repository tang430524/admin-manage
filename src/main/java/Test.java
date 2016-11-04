import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * @author qiang.xie
 * @date 2016/10/31
 */
public class Test {
    public static void main(String[] arg) {
        ExpressionParser exp = new SpelExpressionParser();
        EvaluationContext context = new StandardEvaluationContext();
        System.out.println(exp.parseExpression("1").getValue());
    }
}
