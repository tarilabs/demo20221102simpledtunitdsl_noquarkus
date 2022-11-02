package org.acme;

import static org.assertj.core.api.Assertions.assertThat;

import org.drools.ruleunits.api.RuleUnit;
import org.drools.ruleunits.api.RuleUnitInstance;
import org.drools.ruleunits.api.RuleUnitProvider;
import org.drools.ruleunits.dsl.RuleUnitProviderForDSL;
import org.junit.jupiter.api.Test;

public class RuntimeTest {

    @Test
    public void testR1() {
        SimpleDTUnit unitData = new SimpleDTUnit();
        unitData.getAge().set( 19 );
        unitData.getIncidents().set( false );

        RuleUnitInstance<SimpleDTUnit> unitInstance = RuleUnitProvider.get().createRuleUnitInstance(unitData);

        unitInstance.fire();

        assertThat( unitData.getBasePrice() ).hasValue( 800 );
        System.out.println("Base price: " + unitData.getBasePrice().get());
    }
}