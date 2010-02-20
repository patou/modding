package com.sfeir.modding.client.showcase.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;


public class Static {
    static {
        init();
    }

    private static HashMap<String, String> countriesCapitals;

    public static ArrayList<String> getCountriesList() {
        return sortList(new ArrayList<String>(countriesCapitals.keySet()));
    }

    public static ArrayList<String> getCapitalsList() {
        return new ArrayList<String>(countriesCapitals.values());
    }

    private static ArrayList<String> sortList(ArrayList<String> list) {
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.compareToIgnoreCase(b);
            }
        });
        return list;
    }

    private static void init() {
        countriesCapitals = new HashMap<String, String>();
        countriesCapitals.put("Afghanistan", "Kabul");
        countriesCapitals.put("Albania", "Tirane");
        countriesCapitals.put("Algeria", "Algiers");
        countriesCapitals.put("Andorra", "Andorra la Vella");
        countriesCapitals.put("Angola", "Luanda");
        countriesCapitals.put("Antigua and Barbuda", "Saint John's");
        countriesCapitals.put("Argentina", "Buenos Aires");
        countriesCapitals.put("Armenia", "Yerevan");
        countriesCapitals.put("Australia", "Canberra");
        countriesCapitals.put("Austria", "Vienna");
        countriesCapitals.put("Azerbaijan", "Baku");
        countriesCapitals.put("The Bahamas", "Nassau");
        countriesCapitals.put("Bahrain", "Manama");
        countriesCapitals.put("Bangladesh", "Dhaka");
        countriesCapitals.put("Barbados", "Bridgetown");
        countriesCapitals.put("Belarus", "Minsk");
        countriesCapitals.put("Belgium", "Brussels");
        countriesCapitals.put("Belize", "Belmopan");
        countriesCapitals.put("Benin", "Porto-Novo");
        countriesCapitals.put("Bhutan", "Thimphu");
        countriesCapitals.put("Bolivia", "La Paz (administrative) Sucre (judicial)");
        countriesCapitals.put("Bosnia and Herzegovina", "Sarajevo");
        countriesCapitals.put("Botswana", "Gaborone");
        countriesCapitals.put("Brazil", "Brasilia");
        countriesCapitals.put("Brunei", "Bandar Seri Begawan");
        countriesCapitals.put("Bulgaria", "Sofia");
        countriesCapitals.put("Burkina Faso", "Ouagadougou");
        countriesCapitals.put("Burundi", "Bujumbura");
        countriesCapitals.put("Cambodia", "Phnom Penh");
        countriesCapitals.put("Cameroon", "Yaounde");
        countriesCapitals.put("Canada", "Ottawa");
        countriesCapitals.put("Cape Verde", "Praia");
        countriesCapitals.put("Central African Republic", "Bangui");
        countriesCapitals.put("Chad", "N'Djamena");
        countriesCapitals.put("Chile", "Santiago");
        countriesCapitals.put("China", "Beijing");
        countriesCapitals.put("Colombia", "Bogota");
        countriesCapitals.put("Comoros", "Moroni");
        countriesCapitals.put("Congo, Republic of the", "Brazzaville");
        countriesCapitals.put("Congo, Democratic Republic of the", "Kinshasa");
        countriesCapitals.put("Costa Rica", "San Jose");
        countriesCapitals.put("Cote d'Ivoire", "Yamoussoukro (official) Abidjan (de facto)");
        countriesCapitals.put("Croatia", "Zagreb");
        countriesCapitals.put("Cuba", "Havana");
        countriesCapitals.put("Cyprus ", " Nicosia");
        countriesCapitals.put("Czech Republic ", " Prague");
        countriesCapitals.put("Denmark", "Copenhagen");
        countriesCapitals.put("Djibouti", "Djibouti");
        countriesCapitals.put("Dominica", "Roseau");
        countriesCapitals.put("Dominican Republic", "Santo Domingo");
        countriesCapitals.put("East Timor", "Dili");
        countriesCapitals.put("Ecuador", "Quito");
        countriesCapitals.put("Egypt", "Cairo");
        countriesCapitals.put("El Salvador", "San Salvador");
        countriesCapitals.put("Equatorial Guinea", "Malabo");
        countriesCapitals.put("Eritrea", "Asmara");
        countriesCapitals.put("Estonia", "Tallinn");
        countriesCapitals.put("Ethiopia", "Addis Ababa");
        countriesCapitals.put("Fiji", "Suva");
        countriesCapitals.put("Finland", "Helsinki");
        countriesCapitals.put("France", "Paris");
        countriesCapitals.put("Gabon", "Libreville");
        countriesCapitals.put("The Gambia", "Banjul");
        countriesCapitals.put("Georgia", "Tbilisi");
        countriesCapitals.put("Germany", "Berlin");
        countriesCapitals.put("Ghana", "Accra");
        countriesCapitals.put("Greece", "Athens");
        countriesCapitals.put("Grenada", "Saint George's");
        countriesCapitals.put("Guatemala", "Guatemala City");
        countriesCapitals.put("Guinea", "Conakry");
        countriesCapitals.put("Guinea-Bissau", "Bissau");
        countriesCapitals.put("Guyana", "Georgetown");
        countriesCapitals.put("Haiti", "Port-au-Prince");
        countriesCapitals.put("Honduras", "Tegucigalpa");
        countriesCapitals.put("Hungary", "Budapest");
        countriesCapitals.put("Iceland", "Reykjavik");
        countriesCapitals.put("India", "New Delhi");
        countriesCapitals.put("Indonesia", "Jakarta");
        countriesCapitals.put("Iran", "Tehran");
        countriesCapitals.put("Iraq", "Baghdad");
        countriesCapitals.put("Ireland", "Dublin");
        countriesCapitals.put("Israel", "Jerusalem");
        countriesCapitals.put("Italy", "Rome");
        countriesCapitals.put("Jamaica", "Kingston");
        countriesCapitals.put("Japan", "Tokyo");
        countriesCapitals.put("Jordan", "Amman");
        countriesCapitals.put("Kazakhstan", "Astana");
        countriesCapitals.put("Kenya", "Nairobi");
        countriesCapitals.put("Kiribati", "Tarawa");
        countriesCapitals.put("Korea, North", "Pyongyang");
        countriesCapitals.put("Korea, South", "Seoul");
        countriesCapitals.put("Kuwait", "Kuwait City");
        countriesCapitals.put("Kyrgyzstan", "Bishtek");
        countriesCapitals.put("Laos", "Vientiane");
        countriesCapitals.put("Latvia", "Riga");
        countriesCapitals.put("Lebanon", "Beirut");
        countriesCapitals.put("Lesotho", "Maseru");
        countriesCapitals.put("Liberia", "Monrovia");
        countriesCapitals.put("Libya", "Tripoli");
        countriesCapitals.put("Liechtenstein", "Vaduz");
        countriesCapitals.put("Lithuania", "Vilnius");
        countriesCapitals.put("Luxembourg", "Luxembourg");
        countriesCapitals.put("Macedonia", "Skopje");
        countriesCapitals.put("Madagascar", "Antananarivo");
        countriesCapitals.put("Malawi", "Lilongwe");
        countriesCapitals.put("Malaysia", "Kuala Lumpur");
        countriesCapitals.put("Maldives", "Male");
        countriesCapitals.put("Mali", "Bamko");
        countriesCapitals.put("Malta", "Valletta");
        countriesCapitals.put("Marshall Islands", "Majuro");
        countriesCapitals.put("Mauritania", "Nouakchott");
        countriesCapitals.put("Mauritius", "Port Louis");
        countriesCapitals.put("Mexico", "Mexico City");
        countriesCapitals.put("Federated States of Micronesia", "Palikir");
        countriesCapitals.put("Moldova", "Chisinau");
        countriesCapitals.put("Monaco", "Monaco");
        countriesCapitals.put("Mongolia", "Ulaanbaatar");
        countriesCapitals.put("Morocco", "Rabat");
        countriesCapitals.put("Mozambique", "Maputo");
        countriesCapitals.put("Myanmar (Burma)", "Rangoon");
        countriesCapitals.put("Namibia", "Windhoek");
        countriesCapitals.put("Nauru", "Yaren District");
        countriesCapitals.put("Nepal", "Kathmandu");
        countriesCapitals.put("Netherlands", "Amsterdam");
        countriesCapitals.put("New Zealand", "Wellington");
        countriesCapitals.put("Nicaragua", "Managua");
        countriesCapitals.put("Niger", "Niamey");
        countriesCapitals.put("Nigeria", "Abuja");
        countriesCapitals.put("Norway", "Oslo");
        countriesCapitals.put("Oman", "Muscat");
        countriesCapitals.put("Pakistan", "Islamabad");
        countriesCapitals.put("Palau", "Koror");
        countriesCapitals.put("Panama", "Panama City");
        countriesCapitals.put("Papua New Guinea", "Port Moresby");
        countriesCapitals.put("Paraguay", "Asuncion");
        countriesCapitals.put("Peru", "Lima");
        countriesCapitals.put("Philippines", "Manila");
        countriesCapitals.put("Poland", "Warsaw");
        countriesCapitals.put("Portugal", "Lisbon");
        countriesCapitals.put("Qatar", "Doha");
        countriesCapitals.put("Romania", "Bucharest");
        countriesCapitals.put("Russia", "Moscow");
        countriesCapitals.put("Rwanda", "Kigali");
        countriesCapitals.put("Saint Kitts and Nevis", "Basseterre");
        countriesCapitals.put("Saint Lucia", "Castries");
        countriesCapitals.put("Saint Vincent and the Grenadines", "Kingstown");
        countriesCapitals.put("Samoa", "Apia");
        countriesCapitals.put("San Marino", "San Marino");
        countriesCapitals.put("Sao Tome and Principe", "Sao Tome");
        countriesCapitals.put("Saudi Arabia", "Riyadh");
        countriesCapitals.put("Senegal", "Dakar");
        countriesCapitals.put("Serbia and Montenegro (Yugoslavia)", "Belgrade");
        countriesCapitals.put("Seychelles", "Victoria");
        countriesCapitals.put("Sierra Leone", "Freetown");
        countriesCapitals.put("Singapore", "Singapore");
        countriesCapitals.put("Slovakia", "Bratislava");
        countriesCapitals.put("Slovenia", "Ljubljana");
        countriesCapitals.put("Solomon Islands", "Honiara");
        countriesCapitals.put("Somalia", "Mogadishu");
        countriesCapitals.put("South Africa", "Pretoria (administrative) Cape Town (legislative) Bloemfontein (judiciary)");
        countriesCapitals.put("Spain", "Madrid");
        countriesCapitals.put("Sri Lanka", "Colombo");
        countriesCapitals.put("Sudan", "Khartoum");
        countriesCapitals.put("Suriname", "Paramaribo");
        countriesCapitals.put("Swaziland", "Mbabana");
        countriesCapitals.put("Sweden", "Stockholm");
        countriesCapitals.put("Switzerland", "Bern");
        countriesCapitals.put("Syria", "Damascus");
        countriesCapitals.put("Taiwan", "Taipei");
        countriesCapitals.put("Tajikistan", "Dushanbe");
        countriesCapitals.put("Tanzania", "Dar es Salaam");
        countriesCapitals.put("Thailand", "Bangkok");
        countriesCapitals.put("Togo", "Lome");
        countriesCapitals.put("Tonga", "Nuku'alofa");
        countriesCapitals.put("Trinidad and Tobago", "Port-of-Spain");
        countriesCapitals.put("Tunisia", "Tunis");
        countriesCapitals.put("Turkey", "Ankara");
        countriesCapitals.put("Turkmenistan", "Ashgabat");
        countriesCapitals.put("Tuvalu", "Funafuti");
        countriesCapitals.put("Uganda", "Kampala");
        countriesCapitals.put("Ukraine", "Kiev");
        countriesCapitals.put("United Arab Emirates", "Abu Dhabi");
        countriesCapitals.put("United Kingdom", "London");
        countriesCapitals.put("United States", "Washington D.C.");
        countriesCapitals.put("Uruguay", "Montevideo");
        countriesCapitals.put("Uzbekistan", "Tashkent");
        countriesCapitals.put("Vanuatu", "Port-Vila");
        countriesCapitals.put("Vatican City (Holy See)", "Vatican City");
        countriesCapitals.put("Venezuela", "Caracas");
        countriesCapitals.put("Vietnam", "Hanoi");
        countriesCapitals.put("Yemen", "Sanaa");
        countriesCapitals.put("Zambia", "Lusaka");
        countriesCapitals.put("Zimbabwe", "Harare");
    }
}
