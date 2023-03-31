package com.android.weather.utils

enum class WEATHER_TYPE(val type: String){
    BROKEN_CLOUDS("broken clouds"),
    LIGHT_RAIN("light rain"),
    HAZE("haze"),
    OVERCAST_CLOUDS("overcast clouds"),
    MODERATE_RAIN("moderate rain"),
    FEW_CLOUDS("few clouds"),
    HEAVY_INTENSITY_RAIN("heavy intensity rain"),
    CLEAR_SKY("clear sky"),
    SCATTERED_CLOUDS("scattered clouds")
}

enum class Country(val value: String) {
    AFGHANISTAN("AF"),
    ALAND_ISLANDS("AX"),
    ALBANIA("AL"),
    ALGERIA("DZ"),
    AMERICAN_SAMOA("AS"),
    ANDORRA("AD"),
    ANGOLA("AO"),
    ANGUILLA("AI"),
    ANTARCTICA("AQ"),
    ANTIGUA_AND_BARBUDA("AG"),
    ARGENTINA("AR"),
    ARMENIA("AM"),
    ARUBA("AW"),
    AUSTRALIA("AU"),
    AUSTRIA("AT"),
    AZERBAIJAN("AZ"),
    BAHAMAS("BS"),
    BAHRAIN("BH"),
    BANGLADESH("BD"),
    BARBADOS("BB"),
    BELARUS("BY"),
    BELGIUM("BE"),
    BELIZE("BZ"),
    BENIN("BJ"),
    BERMUDA("BM"),
    BHUTAN("BT"),
    BOLIVIA("BO"),
    BOSNIA_AND_HERZEGOVINA("BA"),
    BOTSWANA("BW"),
    BOUVET_ISLAND("BV"),
    BRAZIL("BR"),
    BRITISH_INDIAN_OCEAN_TERRITORY("IO"),
    BRITISH_VIRGIN_ISLANDS("VG"),
    BRUNEI("BN"),
    BULGARIA("BG"),
    BURKINA_FASO("BF"),
    BURUNDI("BI"),
    CAMBODIA("KH"),
    CAMEROON("CM"),
    CANADA("CA"),
    CAPE_VERDE("CV"),
    CARIBBEAN_NETHERLANDS("BQ"),
    CAYMAN_ISLANDS("KY"),
    CENTRAL_AFRICAN_REPUBLIC("CF"),
    CHAD("TD"),
    CHILE("CL"),
    CHINA("CN"),
    CHRISTMAS_ISLAND("CX"),
    COCOS_KEELING_ISLANDS("CC"),
    COLOMBIA("CO"),
    COMOROS("KM"),
    CONGO_BRAZZAVILLE("CG"),
    CONGO_KINSHASA("CD"),
    COOK_ISLANDS("CK"),
    COSTA_RICA("CR"),
    CROATIA("HR"),
    CUBA("CU"),
    CURACAO("CW"),
    CYPRUS("CY"),
    CZECH_REPUBLIC("CZ"),
    COTE_D_IVOIRE("CI"),
    DENMARK("DK"),
    DJIBOUTI("DJ"),
    DOMINICA("DM"),
    DOMINICAN_REPUBLIC("DO"),
    ECUADOR("EC"),
    EGYPT("EG"),
    EL_SALVADOR("SV"),
    EQUATORIAL_GUINEA("GQ"),
    ERITREA("ER"),
    ESTONIA("EE"),
    ETHIOPIA("ET"),
    FALKLAND_ISLANDS("FK"),
    FAROE_ISLANDS("FO"),
    FIJI("FJ"),
    FINLAND("FI"),
    FRANCE("FR"),
    FRENCH_GUIANA("GF"),
    FRENCH_POLYNESIA("PF"),
    FRENCH_SOUTHERN_TERRITORIES("TF"),
    GABON("GA"),
    GAMBIA("GM"),
    GEORGIA("GE"),
    GERMANY("DE"),
    GHANA("GH"),
    GIBRALTAR("GI"),
    GREECE("GR"),
    GREENLAND("GL"),
    GRENADA("GD"),
    GUADELOUPE("GP"),
    GUAM("GU"),
    GUATEMALA("GT"),
    GUERNSEY("GG"),
    GUINEA("GN"),
    GUINEA_BISSAU("GW"),
    GUYANA("GY"),
    HAITI("HT"),
    HEARD_AND_MCDONALD_ISLANDS("HM"),
    HONDURAS("HN"),
    HONG_KONG_SAR_CHINA("HK"),
    HUNGARY("HU"),
    ICELAND("IS"),
    INDIA("IN"),
    INDONESIA("ID"),
    IRAN("IR"),
    IRAQ("IQ"),
    IRELAND("IE"),
    ISLE_OF_MAN("IM"),
    ISRAEL("IL"),
    ITALY("IT"),
    JAMAICA("JM"),
    JAPAN("JP"),
    JERSEY("JE"),
    JORDAN("JO"),
    KAZAKHSTAN("KZ"),
    KENYA("KE"),
    KIRIBATI("KI"),
    KUWAIT("KW"),
    KYRGYZSTAN("KG"),
    LAOS("LA"),
    LATVIA("LV"),
    LEBANON("LB"),
    LESOTHO("LS"),
    LIBERIA("LR"),
    LIBYA("LY"),
    LIECHTENSTEIN("LI"),
    LITHUANIA("LT"),
    LUXEMBOURG("LU"),
    MACAU_SAR_CHINA("MO"),
    MACEDONIA("MK"),
    MADAGASCAR("MG"),
    MALAWI("MW"),
    MALAYSIA("MY"),
    MALDIVES("MV"),
    MALI("ML"),
    MALTA("MT"),
    MARSHALL_ISLANDS("MH"),
    MARTINIQUE("MQ"),
    MAURITANIA("MR"),
    MAURITIUS("MU"),
    MAYOTTE("YT"),
    MEXICO("MX"),
    MICRONESIA("FM"),
    MOLDOVA("MD"),
    MONACO("MC"),
    MONGOLIA("MN"),
    MONTENEGRO("ME"),
    MONTSERRAT("MS"),
    MOROCCO("MA"),
    MOZAMBIQUE("MZ"),
    MYANMAR_BURMA("MM"),
    NAMIBIA("NA"),
    NAURU("NR"),
    NEPAL("NP"),
    NETHERLANDS("NL"),
    NEW_CALEDONIA("NC"),
    NEW_ZEALAND("NZ"),
    NICARAGUA("NI"),
    NIGER("NE"),
    NIGERIA("NG"),
    NIUE("NU"),
    NORFOLK_ISLAND("NF"),
    NORTH_KOREA("KP"),
    NORTHERN_MARIANA_ISLANDS("MP"),
    NORWAY("NO"),
    OMAN("OM"),
    PAKISTAN("PK"),
    PALAU("PW"),
    PALESTINIAN_TERRITORIES("PS"),
    PANAMA("PA"),
    PAPUA_NEW_GUINEA("PG"),
    PARAGUAY("PY"),
    PERU("PE"),
    PHILIPPINES("PH"),
    PITCAIRN_ISLANDS("PN"),
    POLAND("PL"),
    PORTUGAL("PT"),
    PUERTO_RICO("PR"),
    QATAR("QA"),
    ROMANIA("RO"),
    RUSSIA("RU"),
    RWANDA("RW"),
    REUNION("RE"),
    SAMOA("WS"),
    SAN_MARINO("SM"),
    SAUDI_ARABIA("SA"),
    SENEGAL("SN"),
    SERBIA("RS"),
    SEYCHELLES("SC"),
    SIERRA_LEONE("SL"),
    SINGAPORE("SG"),
    SINT_MAARTEN("SX"),
    SLOVAKIA("SK"),
    SLOVENIA("SI"),
    SOLOMON_ISLANDS("SB"),
    SOMALIA("SO"),
    SOUTH_AFRICA("ZA"),
    SOUTH_GEORGIA_AND_SOUTH_SANDWICH_ISLANDS("GS"),
    SOUTH_KOREA("KR"),
    SOUTH_SUDAN("SS"),
    SPAIN("ES"),
    SRI_LANKA("LK"),
    ST_BARTHELEMY("BL"),
    ST_HELENA("SH"),
    ST_KITTS_AND_NEVIS("KN"),
    ST_LUCIA("LC"),
    ST_MARTIN("MF"),
    ST_PIERRE_AND_MIQUELON("PM"),
    ST_VINCENT_AND_GRENADINES("VC"),
    SUDAN("SD"),
    SURINAME("SR"),
    SVALBARD_AND_JAN_MAYEN("SJ"),
    SWAZILAND("SZ"),
    SWEDEN("SE"),
    SWITZERLAND("CH"),
    SYRIA("SY"),
    SAO_TOME_AND_PRINCIPE("ST"),
    TAIWAN("TW"),
    TAJIKISTAN("TJ"),
    TANZANIA("TZ"),
    THAILAND("TH"),
    TIMOR_LESTE("TL"),
    TOGO("TG"),
    TOKELAU("TK"),
    TONGA("TO"),
    TRINIDAD_AND_TOBAGO("TT"),
    TUNISIA("TN"),
    TURKEY("TR"),
    TURKMENISTAN("TM"),
    TURKS_AND_CAICOS_ISLANDS("TC"),
    TUVALU("TV"),
    US_OUTLYING_ISLANDS("UM"),
    US_VIRGIN_ISLANDS("VI"),
    UGANDA("UG"),
    UKRAINE("UA"),
    UNITED_ARAB_EMIRATES("AE"),
    UNITED_KINGDOM("GB"),
    UNITED_STATES("US"),
    URUGUAY("UY"),
    UZBEKISTAN("UZ"),
    VANUATU("VU"),
    VATICAN_CITY("VA"),
    VENEZUELA("VE"),
    VIETNAM("VN"),
    WALLIS_AND_FUTUNA("WF"),
    WESTERN_SAHARA("EH"),
    YEMEN("YE"),
    ZAMBIA("ZM"),
    ZIMBABWE("ZW")
}