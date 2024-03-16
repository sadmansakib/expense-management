package org.sadmansakib.expensemanagement.grocery;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.jmolecules.archunit.JMoleculesArchitectureRules;
import org.jmolecules.archunit.JMoleculesDddRules;

@AnalyzeClasses(packages = "org.sadmansakib.expensemanagement.grocery")
@SuppressWarnings("unused")
public class GroceryArchTest {
    @ArchTest
    ArchRule dddRules = JMoleculesDddRules.all();

    @ArchTest
    ArchRule hexagonal = JMoleculesArchitectureRules.ensureHexagonal();

    @ArchTest
    ArchRule onionSimple = JMoleculesArchitectureRules.ensureOnionSimple();

    @ArchTest
    ArchRule layeredArchitecture = JMoleculesArchitectureRules.ensureLayeringStrict();
}
