package adduct;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class AdductList {

    public static final Map<String, String> MAPMZPOSITIVEADDUCTS;
    public static final Map<String, String> MAPMZNEGATIVEADDUCTS;

    static {
        Map<String, String> mapMZPositiveAdductsTMP = new LinkedHashMap<>();
        mapMZPositiveAdductsTMP.put("[M+H]+", "-1.007276");
        mapMZPositiveAdductsTMP.put("[M+2H]2+", "-1.007276");
        mapMZPositiveAdductsTMP.put("[M+Na]+", "-22.989218");
        mapMZPositiveAdductsTMP.put("[M+K]+", "-38.963158");
        mapMZPositiveAdductsTMP.put("[M+NH4]+", "-18.033823");
        mapMZPositiveAdductsTMP.put("[M+H-H2O]+", "17.0032");
        mapMZPositiveAdductsTMP.put("[M+H+NH4]2+", "-9.52055");
        mapMZPositiveAdductsTMP.put("[2M+H]+", "-1.007276");
        mapMZPositiveAdductsTMP.put("[2M+Na]+", "-22.989218");
        mapMZPositiveAdductsTMP.put("[M+H+HCOONa]+", "-68.9946");
        mapMZPositiveAdductsTMP.put("[2M+H-H2O]+", "17.0032");
        mapMZPositiveAdductsTMP.put("[M+3H]3+", "-1.007276");
        mapMZPositiveAdductsTMP.put("[M+2H+Na]3+", "-8.33459");
        mapMZPositiveAdductsTMP.put("[M+H+2K]3+", "-26.3112");
        mapMZPositiveAdductsTMP.put("[M+H+2Na]3+", "-15.76619");
        mapMZPositiveAdductsTMP.put("[M+3Na]+", "-22.989218");
        mapMZPositiveAdductsTMP.put("[M+H+Na]2+", "-11.998247");
        mapMZPositiveAdductsTMP.put("[M+H+K]2+", "-19.985217");
        mapMZPositiveAdductsTMP.put("[M+ACN+2H]2+", "-21.52055");
        mapMZPositiveAdductsTMP.put("[M+2Na]2+", "-22.989218");
        mapMZPositiveAdductsTMP.put("[M+2ACN+2H]2+", "-42.033823");
        mapMZPositiveAdductsTMP.put("[M+3ACN+2H]2+", "-62.547097");
        mapMZPositiveAdductsTMP.put("[M+CH3OH+H]+", "-33.033489");
        mapMZPositiveAdductsTMP.put("[M+ACN+H]+", "-42.033823");
        mapMZPositiveAdductsTMP.put("[M+2Na-H]+", "-44.97116");
        mapMZPositiveAdductsTMP.put("[M+IsoProp+H]+", "-61.06534");
        mapMZPositiveAdductsTMP.put("[M+ACN+Na]+", "-64.015765");
        mapMZPositiveAdductsTMP.put("[M+2K-H]+", "-76.91904");
        mapMZPositiveAdductsTMP.put("[M+DMSO+H]+", "-79.02122");
        mapMZPositiveAdductsTMP.put("[M+2ACN+H]+", "-83.06037");
        mapMZPositiveAdductsTMP.put("[M+IsoProp+Na+H]+", "-84.05511");
        mapMZPositiveAdductsTMP.put("[2M+NH4]+", "-18.033823");
        mapMZPositiveAdductsTMP.put("[2M+K]+", "-38.963158");
        mapMZPositiveAdductsTMP.put("[2M+ACN+H]+", "-42.033823");
        mapMZPositiveAdductsTMP.put("[2M+ACN+Na]+", "-64.015765");
        mapMZPositiveAdductsTMP.put("[3M+H]+", "-1.007276");
        mapMZPositiveAdductsTMP.put("[3M+Na]+", "-22.989218");
        mapMZPositiveAdductsTMP.put("[M+H-2H2O]+", "35.0127");
        mapMZPositiveAdductsTMP.put("[M+NH4-H2O]+", "-0.0227");
        mapMZPositiveAdductsTMP.put("[M+Li]+", "-7.0160");
        mapMZPositiveAdductsTMP.put("[2M+2H+3H2O]+", "-28.02312");
        mapMZPositiveAdductsTMP.put("[M+H+CH3COOH]+", "-60.021129");
        mapMZPositiveAdductsTMP.put("[M+H+CH3COONa]+", "-82.00307");
        mapMZPositiveAdductsTMP.put("[M+F+H]+", "-20.00623");
        MAPMZPOSITIVEADDUCTS = Collections.unmodifiableMap(mapMZPositiveAdductsTMP);

        Map<String, String> mapMZNegativeAdductsTMP = new LinkedHashMap<>();
        mapMZNegativeAdductsTMP.put("[M-H]−", "1.007276");
        mapMZNegativeAdductsTMP.put("[M+Cl]−", "-34.969402");
        mapMZNegativeAdductsTMP.put("[M+HCOOH-H]−", "-44.998201");
        mapMZNegativeAdductsTMP.put("[M-H-H2O]−", "19.01839");
        mapMZNegativeAdductsTMP.put("[M-H+HCOONa]−", "-66.9802");
        mapMZNegativeAdductsTMP.put("[M-H+CH3COONa]−", "-80.99525");
        mapMZNegativeAdductsTMP.put("[2M-H]−", "1.007276");
        mapMZNegativeAdductsTMP.put("[M-3H]3−", "1.007276");
        mapMZNegativeAdductsTMP.put("[M-2H]2−", "1.007276");
        mapMZNegativeAdductsTMP.put("[M+Na-2H]−", "-20.974666");
        mapMZNegativeAdductsTMP.put("[M+K-2H]−", "-36.948606");
        mapMZNegativeAdductsTMP.put("[M+CH3COOH-H]−", "-59.013851");
        mapMZNegativeAdductsTMP.put("[M+Br]−", "-78.918885");
        mapMZNegativeAdductsTMP.put("[M+TFA-H]−", "-112.985586");
        mapMZNegativeAdductsTMP.put("[2M+HCOOH-H]−", "-44.998201");
        mapMZNegativeAdductsTMP.put("[2M+CH3COOH-H]−", "-59.013851");
        mapMZNegativeAdductsTMP.put("[3M-H]−", "1.007276");
        mapMZNegativeAdductsTMP.put("[M+F]−", "-18.9984");
        mapMZNegativeAdductsTMP.put("[M+F+H]−", "-20.00623");
        MAPMZNEGATIVEADDUCTS = Collections.unmodifiableMap(mapMZNegativeAdductsTMP);
    }

}
