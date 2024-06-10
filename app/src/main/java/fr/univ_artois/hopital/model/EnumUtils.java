package fr.univ_artois.hopital.model;

public class EnumUtils {
    public static Sexe getSexeIgnoreCase(String name) {
        for (Sexe sexe : Sexe.values()) {
            if (sexe.name().equalsIgnoreCase(name)) {
                return sexe;
            }
        }
        throw new IllegalArgumentException("No enum constant " + Sexe.class.getCanonicalName() + "." + name);
    }
}
