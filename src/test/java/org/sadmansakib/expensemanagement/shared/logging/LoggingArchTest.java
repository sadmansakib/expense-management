package org.sadmansakib.expensemanagement.shared.logging;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.jmolecules.archunit.JMoleculesArchitectureRules;
import org.jmolecules.archunit.JMoleculesDddRules;

@SuppressWarnings("unused")
@AnalyzeClasses(packages = "org.sadmansakib.expensemanagement.shared.logging")
public class LoggingArchTest {
    @ArchTest
    ArchRule dddRules = JMoleculesDddRules.all();

    @ArchTest
    ArchRule hexagonal = JMoleculesArchitectureRules.ensureHexagonal();

    @ArchTest
    ArchRule onionSimple = JMoleculesArchitectureRules.ensureOnionSimple();

    @ArchTest
    ArchRule layeredArchitecture = JMoleculesArchitectureRules.ensureLayeringStrict();
}
