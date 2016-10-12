package com.demo.ts.country;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public enum Country implements Serializable {
    AT("Austria", "AT", "AUT", "A", "040", "+43"), //
    BE("Belgium", "BE", "BEL", "B", "056", "+32"), //
    FR("France", "FR", "FRA", "F", "250", "+33"), //
    DE("Germany", "DE", "DEU", "D", "276", "+49"), //
    IT("Italy", "IT", "ITA", "I", "380", "+39"), //
    LU("Luxembourg", "LU", "LUX", "L", "442", "+352"), //
    NL("Netherlands", "NL", "NLD", "NL", "528", "+31"), //
    PL("Poland", "PL", "POL", "PL", "616", "+48"), //
    PT("Portugal", "PT", "PRT", "PT", "620", "+351"), //
    RO("Romania", "RO", "ROU", "RO", "642", "+40"), //
    ES("Spain", "ES", "ESP", "E", "724", "+34"), //
    CH("Switzerland", "CH", "CHE", "CH", "756", "+41"), //
    GB("United Kingdom", "GB", "GBR", "GB", "826", "+44"), //
    AL("Albania", "AL", "ALB", "AL", "008", "+355"), //
    AD("Andorra", "AD", "AND", "AND", "020", "+376"), //
    BY("Belarus", "BY", "BLR", "BY", "112", "+375"), //
    BA("Bosnia and Herzegovina", "BA", "BIH", "BIH", "070", "+387"), //
    BG("Bulgaria", "BG", "BGR", "BG", "100", "+359"), //
    CY("Cyprus", "CY", "CYP", "CY", "196", "+357"), //
    CZ("Czech Republic", "CZ", "CZE", "CZ", "203", "+420"), //
    DK("Denmark", "DK", "DNK", "DK", "208", "+45"), //
    EE("Estonia", "EE", "EST", "EST", "233", "+372"), //
    FI("Finland", "FI", "FIN", "FIN", "246", "+358"), //
    GR("Greece", "GR", "GRC", "GR", "300", "+30"), //
    HU("Hungary", "HU", "HUN", "H", "348", "+36"), //
    HR("Croatia", "HR", "HRV", "HR", "191", "+385"), //
    IS("Iceland", "IS", "ISL", "ISL", "352", "+354"), // check
    IE("Ireland", "IE", "IRL", "IRL", "372", "+353"), //
    LV("Latvia", "LV", "LVA", "LV", "428", "+371"), //
    LI("Liechtenstein", "LI", "LIE", "FL", "438", "+423"), //
    LT("Lithuania", "LT", "LTU", "LT", "440", "+370"), //
    MK("Macedonia, Republic of", "MK", "MKD", "MK", "807", "+389"), //
    MT("Malta", "MT", "MLT", "M", "470", "+356"), // check
    MD("Moldova", "MD", "MDA", "MD", "498", "+373"), //
    MC("Monaco", "MC", "MCO", "MC", "492", "+377"), //
    ME("Montenegro", "ME", "MNE", "MNE", "499", "+382"), // check
    NO("Norway", "NO", "NOR", "N", "578", "+47"), //
    SM("San Marino", "SM", "SMR", "RSM", "674", "+378"), //
    RS("Serbia", "RS", "SRB", "SRB", "688", "+381"), //
    SK("Slovakia", "SK", "SVK", "SK", "703", "+421"), //
    SI("Slovenia", "SI", "SVN", "SLO", "705", "+386"), //
    SE("Sweden", "SE", "SWE", "S", "752", "+46"), //
    TR("Turkey", "TR", "TUR", "TR", "792", "+90"), //
    UA("Ukraine", "UA", "UKR", "UA", "804", "+380"), //
    DZ("Algeria", "DZ", "DZA", "DZ", "012", "+213"), //
    GI("Gibraltar", "GI", "GIB", "GBZ", "292", "+350"), //
    MA("Morocco", "MA", "MAR", "MA", "504", "+212"), //
    RU("Russian Federation", "RU", "RUS", "RUS", "643", "+7"), //
    TN("Tunisia", "TN", "TUN", "TN", "788", "+216"), //    
    //
    XX("Autres", "XX", "XXX", "XX", "000", "+000"), //
    YU("Serbie-Monténégro", "YU", "YUY", "YU", "001", "+001"), //
    AF("Afghanistan", "AF", "AFG", "AFG", "004", "+93"), //
    AX("Aland Islands", "AX", "ALA", "0", "248", ""), //
    AS("American Samoa", "AS", "ASM", "0", "016", "+1684"), //
    AO("Angola", "AO", "AGO", "0", "024", "+244"), //
    AI("Anguilla", "AI", "AIA", "0", "660", "+1264"), //
    AQ("Antarctica", "AQ", "ATA", "0", "010", ""), //
    AG("Antigua And Barbuda", "AG", "ATG", "0", "028", "+1268"), //
    AR("Argentina", "AR", "ARG", "RA", "032", "+54"), //
    AM("Armenia", "AM", "ARM", "AM", "051", "+374"), //
    AW("Aruba", "AW", "ABW", "0", "533", "+297"), //
    AU("Australia", "AU", "AUS", "AUS", "036", "+61"), //
    AZ("Azerbaijan", "AZ", "AZE", "AZ", "031", "+994"), //
    BS("Bahamas", "BS", "BHS", "BS", "044", "+1242"), //
    BH("Bahrain", "BH", "BHR", "BRN", "048", "+973"), //
    BD("Bangladesh", "BD", "BGD", "BD", "050", "+880"), //
    BB("Barbados", "BB", "BRB", "BDS", "052", "+1246"), //
    BZ("Belize", "BZ", "BLZ", "BH", "084", "+501"), //
    BJ("Benin", "BJ", "BEN", "DY", "204", "+229"), //
    BM("Bermuda", "BM", "BMU", "0", "060", "+1441"), //
    BT("Bhutan", "BT", "BTN", "0", "064", "+975"), //
    BO("Bolivia", "BO", "BOL", "BOL", "068", "+591"), //
    BQ("Bonaire, St. Eustatius, And Saba", "BQ", "BES", "0", "535", "+599"), //
    BW("Botswana", "BW", "BWA", "BW", "072", "+267"), //
    BV("Bouvet Island", "BV", "BVT", "0", "074", ""), //
    BR("Brazil", "BR", "BRA", "BR", "076", "+55"), //
    IO("British Indian Ocean Territory", "IO", "IOT", "0", "086", ""), //
    BN("Brunei Darussalam", "BN", "BRN", "BRU", "096", "+673"), //
    BF("Burkina Faso", "BF", "BFA", "BF", "854", "+226"), //
    BI("Burundi", "BI", "BDI", "RU", "108", "+257"), //
    KH("Cambodia", "KH", "KHM", "K", "116", "+855"), //
    CM("Cameroon", "CM", "CMR", "CAM", "120", "+237"), //
    CA("Canada", "CA", "CAN", "CDN", "124", "+1"), //
    CV("Cape Verde", "CV", "CPV", "0", "132", "+238"), //
    KY("Cayman Islands", "KY", "CYM", "0", "136", "+1345"), //
    CF("Central African Republic", "CF", "CAF", "RCA", "140", "+236"), //
    TD("Chad (Tchad)", "TD", "TCD", "TCH", "148", "+235"), //
    CL("Chile", "CL", "CHL", "RCH", "152", "+56"), //
    CN("China", "CN", "CHN", "0", "156", "+86"), //
    CX("Christmas Island", "CX", "CXR", "0", "162", ""), //
    CC("Cocos (Keeling) Islands", "CC", "CCK", "0", "166", ""), //
    CO("Colombia", "CO", "COL", "CO", "170", "+57"), //
    KM("Comoros", "KM", "COM", "0", "174", "+269"), //
    CG("Congo, Republic Of", "CG", "COG", "RCB", "178", "+242"), //
    CD("Congo, The Democratic Republic Of The (Formerly Zaire)", "CD", "COD", "ZRE", "180", "+243"), //
    CK("Cook Islands", "CK", "COK", "0", "184", "+682"), //
    CR("Costa Rica", "CR", "CRI", "CR", "188", "+506"), //
    CI("Cote D'Ivoire (Ivory Coast)", "CI", "CIV", "CI", "384", "+225"), //
    CU("Cuba", "CU", "CUB", "CU", "192", "+53"), //
    CW("Curacao", "CW", "CUW", "0", "531", "+599"), //
    DJ("Djibouti", "DJ", "DJI", "0", "262", "+253"), //
    DM("Dominica", "DM", "DMA", "WD", "212", "+1767"), //
    DO("Dominican Republic", "DO", "DOM", "DOM", "214", "+1809"), //
    EC("Ecuador", "EC", "ECU", "EC", "218", "+593"), //
    EG("Egypt", "EG", "EGY", "ET", "818", "+20"), //
    SV("El Salvador", "SV", "SLV", "ES", "222", "+503"), //
    GQ("Equatorial Guinea", "GQ", "GNQ", "0", "226", "+240"), //
    ER("Eritrea", "ER", "ERI", "0", "232", "+291"), //
    ET("Ethiopia", "ET", "ETH", "ETH", "231", "+251"), //
    FO("Faeroe Islands", "FO", "FRO", "FR", "234", "+298"), //
    FK("Falkland Islands (Malvinas)", "FK", "FLK", "0", "238", "+500"), //
    FJ("Fiji", "FJ", "FJI", "FJI", "242", "+679"), //
    GF("French Guiana", "GF", "GUF", "0", "254", "+594"), //
    PF("French Polynesia", "PF", "PYF", "0", "258", "+689"), //
    TF("French Southern Territories", "TF", "ATF", "0", "260", ""), //
    GA("Gabon", "GA", "GAB", "G", "266", "+241"), //
    GM("Gambia, The", "GM", "GMB", "WAG", "270", "+220"), //
    GE("Georgia", "GE", "GEO", "GE", "268", ""), //
    GH("Ghana", "GH", "GHA", "GH", "288", "+233"), //
    GL("Greenland", "GL", "GRL", "0", "304", "+299"), //
    GD("Grenada", "GD", "GRD", "WG", "308", "+1473"), //
    GP("Guadeloupe", "GP", "GLP", "0", "312", "+590"), //
    GU("Guam", "GU", "GUM", "0", "316", "+1671"), //
    GT("Guatemala", "GT", "GTM", "GCA", "320", "+502"), //
    GG("Guernsey", "GG", "GGY", "GBG", "000", ""), //
    GN("Guinea", "GN", "GIN", "RG", "324", "+224"), //
    GW("GuineaBissau", "GW", "GNB", "0", "624", "+245"), //
    GY("Guyana", "GY", "GUY", "GUY", "328", "+592"), //
    HT("Haiti", "HT", "HTI", "RH", "332", "+509"), //
    HM("Heard Island And Mcdonald Islands", "HM", "HMD", "0", "334", ""), //
    HN("Honduras", "HN", "HND", "0", "340", "+504"), //
    HK("Hong Kong", "HK", "HKG", "0", "344", "+852"), //
    IN("India", "IN", "IND", "IND", "356", "+91"), //
    ID("Indonesia", "ID", "IDN", "RI", "360", "+62"), //
    IR("Iran (Islamic Republic Of Iran)", "IR", "IRN", "IR", "364", "+98"), //
    IQ("Iraq", "IQ", "IRQ", "IRQ", "368", "+964"), //
    IM("Isle Of Man", "IM", "IMN", "GBM", "833", ""), //
    IL("Israel", "IL", "ISR", "IL", "376", "+972"), //
    JM("Jamaica", "JM", "JAM", "JA", "388", "+1876"), //
    JP("Japan", "JP", "JPN", "J", "392", "+81"), //
    JE("Jersey", "JE", "JEY", "GBJ", "000", ""), //
    JO("Jordan (Hashemite Kingdom Of Jordan)", "JO", "JOR", "HKJ", "400", "+962"), //
    KZ("Kazakhstan", "KZ", "KAZ", "KZ", "398", "+7"), //
    KE("Kenya", "KE", "KEN", "EAK", "404", "+254"), //
    KI("Kiribati", "KI", "KIR", "0", "296", "+686"), //
    KP("Korea (Democratic Peoples Republic Of [North] Korea)", "KP", "PRK", "0", "408", "+850"), //
    KR("Korea (Republic Of [South] Korea)", "KR", "KOR", "ROK", "410", "+82"), //
    KW("Kuwait", "KW", "KWT", "KWT", "414", "+965"), //
    KG("Kyrgyzstan", "KG", "KGZ", "KS", "417", "+996"), //
    LA("Lao People'S Democratic Republic", "LA", "LAO", "LAO", "418", "+856"), //
    LB("Lebanon", "LB", "LBN", "RL", "422", "+961"), //
    LS("Lesotho", "LS", "LSO", "LS", "426", "+266"), //
    LR("Liberia", "LR", "LBR", "LB", "430", "+231"), //
    LY("Libya (Libyan Arab Jamahirya)", "LY", "LBY", "LAR", "434", "+218"), //
    MO("Macao", "MO", "MAC", "0", "446", "+853"), //
    MG("Madagascar", "MG", "MDG", "RM", "450", "+261"), //
    MW("Malawi", "MW", "MWI", "MW", "454", "+265"), //
    MY("Malaysia", "MY", "MYS", "MAL", "458", "+60"), //
    MV("Maldives", "MV", "MDV", "0", "462", "+960"), //
    ML("Mali", "ML", "MLI", "RMM", "466", "+223"), //
    MH("Marshall Islands", "MH", "MHL", "0", "584", "+692"), //
    MQ("Martinique", "MQ", "MTQ", "0", "474", "+596"), //
    MR("Mauritania", "MR", "MRT", "RIM", "478", "+222"), //
    MU("Mauritius", "MU", "MUS", "MS", "480", "+230"), //
    YT("Mayotte", "YT", "MYT", "0", "175", "+269"), //
    MX("Mexico", "MX", "MEX", "MEX", "484", "+52"), //
    FM("Micronesia (Federated States Of Micronesia)", "FM", "FSM", "0", "583", "+691"), //
    MN("Mongolia", "MN", "MNG", "MGL", "496", "+976"), //
    MS("Montserrat", "MS", "MSR", "0", "500", "+1664"), //
    MZ("Mozambique (Mocambique)", "MZ", "MOZ", "MOC", "508", "+258"), //
    MM("Myanmar (Formerly Burma)", "MM", "MMR", "BUR", "104", "+95"), //
    NA("Namibia", "NA", "NAM", "NAM", "516", "+264"), //
    NR("Nauru", "NR", "NRU", "NAU", "520", "+674"), //
    NP("Nepal", "NP", "NPL", "NEP", "524", "+977"), //
    AN("Netherlands Antilles (Obsolete)", "AN", "ANT", "NA", "530", "+599"), //
    NC("New Caledonia", "NC", "NCL", "0", "540", "+687"), //
    NZ("New Zealand", "NZ", "NZL", "NZ", "554", "+64"), //
    NI("Nicaragua", "NI", "NIC", "NIC", "558", "+505"), //
    NE("Niger", "NE", "NER", "RN", "562", "+227"), //
    NG("Nigeria", "NG", "NGA", "WAN", "566", "+234"), //
    NU("Niue", "NU", "NIU", "0", "570", "+683"), //
    NF("Norfolk Island", "NF", "NFK", "0", "574", ""), //
    MP("Northern Mariana Islands", "MP", "MNP", "0", "580", "+1670"), //
    OM("Oman", "OM", "OMN", "0", "512", "+968"), //
    PK("Pakistan", "PK", "PAK", "PK", "586", "+92"), //
    PW("Palau", "PW", "PLW", "0", "585", "+680"), //
    PS("Palestinian Territories", "PS", "PSE", "0", "275", "+970"), //
    PA("Panama", "PA", "PAN", "PA", "591", "+507"), //
    PG("Papua New Guinea", "PG", "PNG", "PNG", "598", "+675"), //
    PY("Paraguay", "PY", "PRY", "PY", "600", "+595"), //
    PE("Peru", "PE", "PER", "PE", "604", "+51"), //
    PH("Philippines", "PH", "PHL", "RP", "608", "+63"), //
    PN("Pitcairn", "PN", "PCN", "0", "612", ""), //
    PR("Puerto Rico", "PR", "PRI", "0", "630", "+1"), //
    QA("Qatar", "QA", "QAT", "Q", "634", "+974"), //
    RE("Reunion", "RE", "REU", "0", "638", "+262"), //
    RW("Rwanda", "RW", "RWA", "RWA", "646", "+250"), //
    BL("Saint Barthelemy", "BL", "BLM", "0", "652", ""), //
    SH("Saint Helena", "SH", "SHN", "0", "654", "+290"), //
    KN("Saint Kitts And Nevis", "KN", "KNA", "0", "659", "+1869"), //
    LC("Saint Lucia", "LC", "LCA", "WL", "662", "+1758"), //
    MF("Saint Martin (French Portion)", "MF", "MAF", "0", "663", ""), //
    PM("Saint Pierre And Miquelon", "PM", "SPM", "0", "666", "+508"), //
    VC("Saint Vincent And The Grenadines", "VC", "VCT", "WV", "670", "+1784"), //
    WS("Samoa (Formerly Western Samoa)", "WS", "WSM", "WS", "882", "+685"), //
    ST("Sao Tome And Principe", "ST", "STP", "0", "678", "+239"), //
    SA("Saudi Arabia (Kingdom Of Saudi Arabia)", "SA", "SAU", "SA", "682", "+966"), //
    SN("Senegal", "SN", "SEN", "SN", "686", "+221"), //
    SC("Seychelles", "SC", "SYC", "SY", "690", "+248"), //
    SL("Sierra Leone", "SL", "SLE", "WAL", "694", "+232"), //
    SG("Singapore", "SG", "SGP", "SGP", "702", "+65"), //
    SX("Sint Maarten", "SX", "SXM", "0", "534", "+599"), //
    SB("Solomon Islands", "SB", "SLB", "0", "090", "+677"), //
    SO("Somalia", "SO", "SOM", "SO", "706", "+252"), //
    ZA("South Africa (Zuid Afrika)", "ZA", "ZAF", "ZA", "710", "+27"), //
    GS("South Georgia And The South Sandwich Islands", "GS", "SGS", "0", "239", ""), //
    SS("South Sudan", "SS", "SSD", "0", "000", ""), //
    LK("Sri Lanka (Formerly Ceylon)", "LK", "LKA", "CL", "144", "+94"), //
    SD("Sudan", "SD", "SDN", "SUD", "736", "+249"), //
    SR("Suriname", "SR", "SUR", "SME", "740", "+597"), //
    SJ("Svalbard And Jan Mayen", "SJ", "SJM", "0", "744", ""), //
    SZ("Swaziland", "SZ", "SWZ", "SD", "748", "+268"), //
    SY("Syrian Arab Republic", "SY", "SYR", "SYR", "760", "+963"), //
    TW("Taiwan", "TW", "TWN", "0", "158", "+886"), //
    TJ("Tajikistan", "TJ", "TJK", "TJ", "762", "+992"), //
    TZ("Tanzania", "TZ", "TZA", "0", "834", "+255"), //
    TH("Thailand", "TH", "THA", "T", "764", "+66"), //
    TL("TimorLeste (Formerly East Timor)", "TL", "TLS", "0", "626", "+670"), //
    TG("Togo", "TG", "TGO", "TG", "768", "+228"), //
    TK("Tokelau", "TK", "TKL", "0", "772", "+690"), //
    TO("Tonga", "TO", "TON", "0", "776", "+676"), //
    TT("Trinidad And Tobago", "TT", "TTO", "TT", "780", "+1868"), //
    TM("Turkmenistan", "TM", "TKM", "TM", "795", "+993"), //
    TC("Turks And Caicos Islands", "TC", "TCA", "0", "796", "+1649"), //
    TV("Tuvalu", "TV", "TUV", "0", "798", "+688"), //
    UG("Uganda", "UG", "UGA", "EAU", "800", "+256"), //
    AE("United Arab Emirates", "AE", "ARE", "0", "784", "+971"), //
    US("United States", "US", "USA", "USA", "840", "+1"), //
    UM("United States Minor Outlying Islands", "UM", "UMI", "0", "581", ""), //
    UY("Uruguay", "UY", "URY", "ROU", "858", "+598"), //
    UZ("Uzbekistan", "UZ", "UZB", "UZ", "860", "+998"), //
    VU("Vanuatu", "VU", "VUT", "0", "548", "+678"), //
    VA("Vatican City (Holy See)", "VA", "VAT", "V", "336", "+379"), //
    VE("Venezuela", "VE", "VEN", "YV", "862", "+58"), //
    VN("Viet Nam", "VN", "VNM", "VN", "704", "+84"), //
    VG("Virgin Islands, British", "VG", "VGB", "BVI", "092", "+1284"), //
    VI("Virgin Islands, U.S.", "VI", "VIR", "0", "850", "+1340"), //
    WF("Wallis And Futuna", "WF", "WLF", "0", "876", "+681"), //
    EH("Western Sahara (Formerly Spanish Sahara)", "EH", "ESH", "0", "732", ""), //
    YE("Yemen (Yemen Arab Republic)", "YE", "YEM", "YAR", "887", "+967"), //
    ZM("Zambia (Formerly Northern Rhodesia)", "ZM", "ZMB", "RNR", "894", "+260"), //
    ZW("Zimbabwe", "ZW", "ZWE", "ZW", "716", "+263"), //
    ANY("Any", "ANY", "ANY", "ANY", "999", "+9999"); //
    

    private final String name;
    private final String ISO2Code;
    private final String ISO3Code;
    private final String iruCode;
    private final String ISONumeric;
    private final String phoneCode;

    Country(String name, String iso2Code, String iso3Code, String iruCode, String isoNumeric, String phoneCode) {
        this.name = name;
        this.ISO3Code = iso3Code;
        this.ISO2Code = iso2Code;
        this.iruCode = iruCode;
        this.ISONumeric = isoNumeric;
        this.phoneCode = phoneCode;
    }

    public static Country getByCode(String code) {
        Country result = null;
        for (Country country : Country.values()) {
            boolean isIso2 = country.getISO2Code().equals(code);
            boolean isIso3 = country.getISO3Code().equals(code);
            boolean isIruCode = country.getIruCode().equals(code);
            boolean isNumeric = country.getISONumeric().equals(code);
            boolean isPhoneCode = country.getPhoneCode().equals(code);

            if (isIso2 || isIso3 || isNumeric || isIruCode || isPhoneCode) {
                result = country;
                break;
            }
        }
        return result;
    }

    public static Country getCountryByPhoneNumber(String fullPhoneNumber) {
        Country result = null;
        if (fullPhoneNumber != null && !fullPhoneNumber.isEmpty()) {
            for (Country country : values()) {
                if (country.getPhoneCode() != "" && fullPhoneNumber.startsWith(country.getPhoneCode())) {
                    result = country;
                    break;
                }
            }
        }
        return result;
    }

    public String getISO3Code() {
        return ISO3Code;
    }

    public String getISO2Code() {
        return ISO2Code;
    }

    public String getISONumeric() {
        return ISONumeric;
    }

    public String getIruCode() {
        return iruCode;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public String getName() {
        return name;
    }

    public static Map<Country, Long> getCountryMap() {
        Map<Country, Long> map = new HashMap<>();
        for (Country country : Country.values()) {
            map.put(country, 0L);
        }
        return map;
    }

    @Override
    public String toString() {
        return name;
    }

}
