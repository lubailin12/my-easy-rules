
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.core.RulesEngineParameters;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
		/********************** example 1 *******************/
        // define facts
        Facts facts1 = new Facts();
        facts1.put("rain", true);

        // define rules
        WeatherRule weatherRule = new WeatherRule();
        Rules rules1 = new Rules();
        rules1.register(weatherRule);

        // fire rules on known facts
        RulesEngine rulesEngine = new DefaultRulesEngine();
        rulesEngine.fire(rules1, facts1);
		System.out.println();
		
		/********************** example 2 *******************/
		// create a rules engine
        RulesEngineParameters parameters = new RulesEngineParameters().skipOnFirstAppliedRule(true);
        RulesEngine fizzBuzzEngine = new DefaultRulesEngine(parameters);

        // create rules
        Rules rules2 = new Rules();
        rules2.register(new FizzRule());
        rules2.register(new BuzzRule());
        rules2.register(new FizzBuzzRule(new FizzRule(), new BuzzRule()));
        rules2.register(new NoFizzBuzzRule());

        // fire rules
        Facts facts2 = new Facts();
        for (int i = 1; i <= 100; i++) {
            facts2.put("number", i);
            fizzBuzzEngine.fire(rules2, facts2);
            System.out.println();
        }
    }
}
