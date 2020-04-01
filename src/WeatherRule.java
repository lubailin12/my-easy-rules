

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Priority;
import org.jeasy.rules.annotation.Rule;
import org.jeasy.rules.annotation.Fact;

@Rule(name = "weather rule", description = "if it rains then take an umbrella" )
public class WeatherRule {

    @Condition
    public boolean itRains(@Fact("rain") boolean rain) {
        return rain;
    }
    
    @Action
    public void takeAnUmbrella() {
        System.out.println("It rains, take an umbrella!");
    }
}