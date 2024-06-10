package io.github.abdulroufsidhu.ambaar.address

import io.github.abdulroufsidhu.ambaar.branch.Branch
import io.github.abdulroufsidhu.ambaar.core.BaseTable
import io.github.abdulroufsidhu.ambaar.user.User
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import jakarta.persistence.UniqueConstraint
import java.time.Instant

@Entity
@Table(
    name = "addresses",
    uniqueConstraints = [
        UniqueConstraint(
            name = "address_unique_constraint",
            columnNames = ["street", "city", "state", "zip", "country"]
        )
    ]
)
data class Address(
    var street: String? = null,
    var city: String? = null,
    var state: String? = null,
    var zip: String? = null,
    @Enumerated(EnumType.STRING)
    var country: Country? = null,
    @OneToMany(mappedBy = "address", fetch = FetchType.LAZY)
    var branches: List<Branch>? = null,
    @OneToMany(mappedBy = "address", fetch = FetchType.LAZY)
    var users: List<User>? = null,
    override var id: String? = null,
    override var createdAt: Instant? = null,
    override var updatedAt: Instant? = null,
) : BaseTable(id, createdAt, updatedAt) {
    enum class Country(val code: String, val countryName: String) {
        AFGHANISTAN("AF", "Afghanistan"),
        ALBANIA("AL", "Albania"),
        ALGERIA("DZ", "Algeria"),
        ANDORRA("AD", "Andorra"),
        ANGOLA("AO", "Angola"),
        ANTIGUA_AND_BARBUDA("AG", "Antigua and Barbuda"),
        ARGENTINA("AR", "Argentina"),
        ARMENIA("AM", "Armenia"),
        AUSTRALIA("AU", "Australia"),
        AUSTRIA("AT", "Austria"),
        AZERBAIJAN("AZ", "Azerbaijan"),
        BAHAMAS("BS", "Bahamas"),
        BAHRAIN("BH", "Bahrain"),
        BANGLADESH("BD", "Bangladesh"),
        BARBADOS("BB", "Barbados"),
        BELARUS("BY", "Belarus"),
        BELGIUM("BE", "Belgium"),
        BELIZE("BZ", "Belize"),
        BENIN("BJ", "Benin"),
        BHUTAN("BT", "Bhutan"),
        BOLIVIA("BO", "Bolivia"),
        BOSNIA_AND_HERZEGOVINA("BA", "Bosnia and Herzegovina"),
        BOTSWANA("BW", "Botswana"),
        BRAZIL("BR", "Brazil"),
        BRUNEI("BN", "Brunei"),
        BULGARIA("BG", "Bulgaria"),
        BURKINA_FASO("BF", "Burkina Faso"),
        BURUNDI("BI", "Burundi"),
        CABO_VERDE("CV", "Cabo Verde"),
        CAMBODIA("KH", "Cambodia"),
        CAMEROON("CM", "Cameroon"),
        CANADA("CA", "Canada"),
        CENTRAL_AFRICAN_REPUBLIC("CF", "Central African Republic"),
        CHAD("TD", "Chad"),
        CHILE("CL", "Chile"),
        CHINA("CN", "China"),
        COLOMBIA("CO", "Colombia"),
        COMOROS("KM", "Comoros"),
        CONGO_DEMOCRATIC_REPUBLIC("CD", "Congo, Democratic Republic of the"),
        CONGO_REPUBLIC("CG", "Congo, Republic of the"),
        COSTA_RICA("CR", "Costa Rica"),
        CROATIA("HR", "Croatia"),
        CUBA("CU", "Cuba"),
        CYPRUS("CY", "Cyprus"),
        CZECH_REPUBLIC("CZ", "Czech Republic"),
        DENMARK("DK", "Denmark"),
        DJIBOUTI("DJ", "Djibouti"),
        DOMINICA("DM", "Dominica"),
        DOMINICAN_REPUBLIC("DO", "Dominican Republic"),
        EAST_TIMOR("TL", "East Timor"),
        ECUADOR("EC", "Ecuador"),
        EGYPT("EG", "Egypt"),
        EL_SALVADOR("SV", "El Salvador"),
        EQUATORIAL_GUINEA("GQ", "Equatorial Guinea"),
        ERITREA("ER", "Eritrea"),
        ESTONIA("EE", "Estonia"),
        ESWATINI("SZ", "Eswatini"),
        ETHIOPIA("ET", "Ethiopia"),
        FIJI("FJ", "Fiji"),
        FINLAND("FI", "Finland"),
        FRANCE("FR", "France"),
        GABON("GA", "Gabon"),
        GAMBIA("GM", "Gambia"),
        GEORGIA("GE", "Georgia"),
        GERMANY("DE", "Germany"),
        GHANA("GH", "Ghana"),
        GREECE("GR", "Greece"),
        GRENADA("GD", "Grenada"),
        GUATEMALA("GT", "Guatemala"),
        GUINEA("GN", "Guinea"),
        GUINEA_BISSAU("GW", "Guinea-Bissau"),
        GUYANA("GY", "Guyana"),
        HAITI("HT", "Haiti"),
        HONDURAS("HN", "Honduras"),
        HUNGARY("HU", "Hungary"),
        ICELAND("IS", "Iceland"),
        INDIA("IN", "India"),
        INDONESIA("ID", "Indonesia"),
        IRAN("IR", "Iran"),
        IRAQ("IQ", "Iraq"),
        IRELAND("IE", "Ireland"),
        ISRAEL("IL", "Israel"),
        ITALY("IT", "Italy"),
        IVORY_COAST("CI", "Ivory Coast"),
        JAMAICA("JM", "Jamaica"),
        JAPAN("JP", "Japan"),
        JORDAN("JO", "Jordan"),
        KAZAKHSTAN("KZ", "Kazakhstan"),
        KENYA("KE", "Kenya"),
        KIRIBATI("KI", "Kiribati"),
        KOSOVO("XK", "Kosovo"),
        KUWAIT("KW", "Kuwait"),
        KYRGYZSTAN("KG", "Kyrgyzstan"),
        LAOS("LA", "Laos"),
        LATVIA("LV", "Latvia"),
        LEBANON("LB", "Lebanon"),
        LESOTHO("LS", "Lesotho"),
        LIBERIA("LR", "Liberia"),
        LIBYA("LY", "Libya"),
        LIECHTENSTEIN("LI", "Liechtenstein"),
        LITHUANIA("LT", "Lithuania"),
        LUXEMBOURG("LU", "Luxembourg"),
        MADAGASCAR("MG", "Madagascar"),
        MALAWI("MW", "Malawi"),
        MALAYSIA("MY", "Malaysia"),
        MALDIVES("MV", "Maldives"),
        MALI("ML", "Mali"),
        MALTA("MT", "Malta"),
        MARSHALL_ISLANDS("MH", "Marshall Islands"),
        MAURITANIA("MR", "Mauritania"),
        MAURITIUS("MU", "Mauritius"),
        MEXICO("MX", "Mexico"),
        MICRONESIA("FM", "Micronesia"),
        MOLDOVA("MD", "Moldova"),
        MONACO("MC", "Monaco"),
        MONGOLIA("MN", "Mongolia"),
        MONTENEGRO("ME", "Montenegro"),
        MOROCCO("MA", "Morocco"),
        MOZAMBIQUE("MZ", "Mozambique"),
        MYANMAR("MM", "Myanmar"),
        NAMIBIA("NA", "Namibia"),
        NAURU("NR", "Nauru"),
        NEPAL("NP", "Nepal"),
        NETHERLANDS("NL", "Netherlands"),
        NEW_ZEALAND("NZ", "New Zealand"),
        NICARAGUA("NI", "Nicaragua"),
        NIGER("NE", "Niger"),
        NIGERIA("NG", "Nigeria"),
        NORTH_KOREA("KP", "North Korea"),
        NORTH_MACEDONIA("MK", "North Macedonia"),
        NORWAY("NO", "Norway"),
        OMAN("OM", "Oman"),
        PAKISTAN("PK", "Pakistan"),
        PALAU("PW", "Palau"),
        PALESTINE("PS", "Palestine"),
        PANAMA("PA", "Panama"),
        PAPUA_NEW_GUINEA("PG", "Papua New Guinea"),
        PARAGUAY("PY", "Paraguay"),
        PERU("PE", "Peru"),
        PHILIPPINES("PH", "Philippines"),
        POLAND("PL", "Poland"),
        PORTUGAL("PT", "Portugal"),
        QATAR("QA", "Qatar"),
        ROMANIA("RO", "Romania"),
        RUSSIA("RU", "Russia"),
        RWANDA("RW", "Rwanda"),
        SAINT_KITTS_AND_NEVIS("KN", "Saint Kitts and Nevis"),
        SAINT_LUCIA("LC", "Saint Lucia"),
        SAINT_VINCENT_AND_THE_GRENADINES("VC", "Saint Vincent and the Grenadines"),
        SAMOA("WS", "Samoa"),
        SAN_MARINO("SM", "San Marino"),
        SAO_TOME_AND_PRINCIPE("ST", "Sao Tome and Principe"),
        SAUDI_ARABIA("SA", "Saudi Arabia"),
        SENEGAL("SN", "Senegal"),
        SERBIA("RS", "Serbia"),
        SEYCHELLES("SC", "Seychelles"),
        SIERRA_LEONE("SL", "Sierra Leone"),
        SINGAPORE("SG", "Singapore"),
        SLOVAKIA("SK", "Slovakia"),
        SLOVENIA("SI", "Slovenia"),
        SOLOMON_ISLANDS("SB", "Solomon Islands"),
        SOMALIA("SO", "Somalia"),
        SOUTH_AFRICA("ZA", "South Africa"),
        SOUTH_KOREA("KR", "South Korea"),
        SOUTH_SUDAN("SS", "South Sudan"),
        SPAIN("ES", "Spain"),
        SRI_LANKA("LK", "Sri Lanka"),
        SUDAN("SD", "Sudan"),
        SURINAME("SR", "Suriname"),
        SWEDEN("SE", "Sweden"),
        SWITZERLAND("CH", "Switzerland"),
        SYRIA("SY", "Syria"),
        TAIWAN("TW", "Taiwan"),
        TAJIKISTAN("TJ", "Tajikistan"),
        TANZANIA("TZ", "Tanzania"),
        THAILAND("TH", "Thailand"),
        TOGO("TG", "Togo"),
        TONGA("TO", "Tonga"),
        TRINIDAD_AND_TOBAGO("TT", "Trinidad and Tobago"),
        TUNISIA("TN", "Tunisia"),
        TURKEY("TR", "Turkey"),
        TURKMENISTAN("TM", "Turkmenistan"),
        TUVALU("TV", "Tuvalu"),
        UGANDA("UG", "Uganda"),
        UKRAINE("UA", "Ukraine"),
        UNITED_ARAB_EMIRATES("AE", "United Arab Emirates"),
        UNITED_KINGDOM("GB", "United Kingdom"),
        UNITED_STATES("US", "United States"),
        URUGUAY("UY", "Uruguay"),
        UZBEKISTAN("UZ", "Uzbekistan"),
        VANUATU("VU", "Vanuatu"),
        VATICAN_CITY("VA", "Vatican City"),
        VENEZUELA("VE", "Venezuela"),
        VIETNAM("VN", "Vietnam"),
        YEMEN("YE", "Yemen"),
        ZAMBIA("ZM", "Zambia"),
        ZIMBABWE("ZW", "Zimbabwe");

        companion object {
            fun fromCode(code: String): Country? {
                return entries.find { it.code == code }
            }

            fun fromCountryName(countryName: String): Country? {
                return entries.find { it.countryName.equals(countryName, ignoreCase = true) }
            }
        }
    }

    /*
        @Converter
        class CountryConverter : AttributeConverter<Country, String> {
            @Throws(NullPointerException::class)
            override fun convertToDatabaseColumn(attribute: Country?): String =
                attribute?.countryName ?: throw NullPointerException("Country cannot be null")

            @Throws(NullPointerException::class, IllegalArgumentException::class)
            override fun convertToEntityAttribute(dbData: String?): Country =
                Country.fromCountryName(dbData ?: throw NullPointerException("Country cannot be null"))
                    ?: throw IllegalArgumentException("Invalid country code")
        }
    */

}

