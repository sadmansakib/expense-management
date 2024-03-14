package org.sadmansakib.expensemanagement.expense;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.jmolecules.archunit.JMoleculesArchitectureRules;
import org.jmolecules.archunit.JMoleculesDddRules;

@AnalyzeClasses(packages = "org.sadmansakib.expensemanagement.expense")
@SuppressWarnings("unused")
public class ExpenseArchTest {
    @ArchTest
    ArchRule dddRules = JMoleculesDddRules.all();

    @ArchTest
    ArchRule hexagonal = JMoleculesArchitectureRules.ensureHexagonal();

    @ArchTest
    ArchRule onionSimple = JMoleculesArchitectureRules.ensureOnionSimple();

    @ArchTest
    ArchRule layeredArchitecture = JMoleculesArchitectureRules.ensureLayeringStrict();
}
