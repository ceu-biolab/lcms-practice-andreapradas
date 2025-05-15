package main;

import lipid.*;
import org.drools.ruleunits.api.RuleUnitInstance;
import org.drools.ruleunits.api.RuleUnitProvider;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        LipidScoreUnit lipidScoreUnit = new LipidScoreUnit();

        // Crear algunas anotaciones de prueba
        Lipid l1 = new Lipid(1, "TG 52:3", "C55H100O6", "TG", 52, 3);
        Lipid l2 = new Lipid(2, "TG 54:3", "C57H104O6", "TG", 54, 3);
        Lipid l3 = new Lipid(3, "TG 56:3", "C59H108O6", "TG", 56, 3);

        Annotation a1 = new Annotation(l1, 857.7593, 10E6, 9d, IoniationMode.POSITIVE);
        Annotation a2 = new Annotation(l2, 885.79056, 10E6, 10d, IoniationMode.POSITIVE);
        Annotation a3 = new Annotation(l3, 913.822, 10E6, 11d, IoniationMode.POSITIVE);

        lipidScoreUnit.getAnnotations().add(a1);
        lipidScoreUnit.getAnnotations().add(a2);
        lipidScoreUnit.getAnnotations().add(a3);


        RuleUnitInstance<LipidScoreUnit> instance = RuleUnitProvider.get().createRuleUnitInstance(lipidScoreUnit);

        try {
            System.out.println(">>> Ejecutando reglas...");
            instance.fire();

            System.out.println("\n>>> Resultados:");
            for (Annotation a : List.of(a1, a2, a3)) {
                System.out.printf("%s -> Score: %d, Normalized: %.2f%n",
                        a.getLipid().getName(), a.getScore(), a.getNormalizedScore());
            }

        } finally {
            instance.close();
        }
    }
}
