package opendata.a00965170.comp3717.bcit.ca.assignment1;

import android.util.Log;

import opendata.a00965170.comp3717.bcit.ca.database.schema.Categories;
import opendata.a00965170.comp3717.bcit.ca.database.schema.CategoriesDao;
import opendata.a00965170.comp3717.bcit.ca.database.schema.Datasets;

/**
 * Created by NamBlue on 2/7/2017.
 */

public class DatabasePopulator
{
    public static DatabaseHelper helper;

    public static void populateDatabase()
    {
        if (helper != null)
        {
            populateCategories();
            populateCityData();
            populateCityLand();
            populateUndergroundData();
            populateMiscellaneous();
            populatePublicUtilities();
            populateStreetInformation();
        }
        else
        {
            Log.e("Error: ","Called DatabasePopulator without providing the helper context");
        }
    }

    public static void populateCategories()
    {
        helper.createCategory("City Data", 1L);
        helper.createCategory("City Land Information", 2L);
        helper.createCategory("City Underground Related Data", 3L);
        helper.createCategory("Miscellaneous", 4L);
        helper.createCategory("Public Utilities", 5L);
        helper.createCategory("Street Information", 6L);
    }

    public static void populateCityData()
    {
        helper.createDataset("Business Licenses (Active - Resident)", "New" +
                " Westminster has an annual renewal of approximately 4,000 business licenses each" +
                " year. Business Licensing also issues licenses for liquor establishments and " +
                "municipal decals.\n" +
                "\n" +
                "Things to know\n" +
                "\n" +
                "1) Before you sign a lease, it’s important for prospective business owners who " +
                "are applying for business licenses to check with the Building, Planning and " +
                "Licensing divisions on property they wish to lease or buy in regards to " +
                "outstanding orders or issues pertaining to that property.\n" +
                "\n" +
                "2) Before you sign a lease, check with the Planning and Building Department to " +
                "make sure your business is a permitted use on the site.\n" +
                "\n" +
                "3) Before you purchase a sign for your business, review the requirements of the " +
                "sign bylaw with the Planning Division. Click here for Sign Permit information.\n" +
                "\n" +
                "4) Each space in a building has its own specific approved use and sometimes the " +
                "use of that space cannot be changed without approval and/or permit.\n" +
                "\n" +
                "https://www.newwestcity.ca/business_licences.php", 1L);
        helper.createDataset("Business Licenses (Inter-Municipal)", "As of October " +
                "1, 2013, an Inter-municipal Business License will be available in the Metro West" +
                " region. For $250, eligible businesses may be licensed to work in all of the " +
                "following municipalities: City of New Westminster, City of Burnaby, Corporation " +
                "of Delta, City of Richmond, City of Surrey, and City of Vancouver.\n" +
                "\n" +
                "Eligibility is limited to inter-municipal businesses, defined as trades " +
                "contractors or other professionals (related to the construction industry) that " +
                "provide a service or product other than from their fixed and permanent location." +
                " Only eligible businesses which have fixed and permanent location in one of the " +
                "participating municipalities are eligible for the IMBL.\n" +
                "\n" +
                "For further information, please contact the City of New Westminster Business " +
                "Licensing Office at 604-527-4565.\n" +
                "\n" +
                "https://www.newwestcity.ca/business_licences.php", 1L);
        helper.createDataset("Business Licenses (New for 2016)", "Every business in" +
                " the City of New Westminster is required to have a valid business license before" +
                " beginning operation. This includes home-based businesses, commercial and " +
                "industrial operations and owners of apartment rental properties.\n" +
                "\n" +
                "http://www.newwestcity.ca/business/permits_licenses/business_licences.php", 1L);
        helper.createDataset("Business Licenses (Non-Residents)", "Contractors from different municipalities doing business within New Westminster https://www.newwestcity.ca/business_licences.php", 1L);
        helper.createDataset("City Energy Use Through Time", "Financial disclosure form completed annually by all elected officials. Shows the amount of energy consumed and greenhouse gases created through time.", 1L);
        helper.createDataset("Councillor Contact Information", "The City of New Westminster wants to facilitate residents and the general public access to the elected officials of the City.", 1L);
        helper.createDataset("Demographic - Detailed Age Profile (Census 2011)", "Census 2011 information summarized by ages (by individual years of age and age groupings) and gender, neighborhoods, census tracts and dissemination areas. Also contains descriptive information about the data source files and notes about the use of the data.", 1L);
        helper.createDataset("Demographic Profiles (Census 1986,1991,1996,2001,2006)", "Information for the City of New Westminster from the 1986, 1991, 1996, 2001 and 2006 Censuses.\n" +
                "\n" +
                "This information includes age, housing characteristics, immigration, ethnicity, " +
                "labour force, population change, income, education, household type, language " +
                "information etc. Also contains descriptive information about the data source " +
                "files and notes about the use of the data.", 1L);
        helper.createDataset("Demographic Profiles (Census 2011)", "2011 census " +
                "information summarized by\n" +
                "\n" +
                "a) city b) neighborhoods c) census tracts and d) dissemination areas.\n" +
                "\n" +
                "Census information includes age, household type, family type, mother tongue, " +
                "home language, type of dwelling etc. Also contains descriptive information about" +
                " the data source files and notes about the use of the data.", 1L);
        helper.createDataset("Demographic Profiles (National Household Survey 2011)", "Contains tabs with 2011 National Household Survey information for the City of New Westminster, New Westminster neighbourhoods and New Westminster census tracts. National Household Survey includes information on income, housing characteristics, ethnicity, immigration, education, labour force etc. Also contains descriptive information about the data source files and notes about the use of the data.", 1L);
        helper.createDataset("Election Results 1990 - Present", "The spreadsheet provides the candidates, voting locations and the results for the candidate both total and by location for each election from 1990 forward.", 1L);
        helper.createDataset("Emergency Incidents By Fire Hall", "Emergency incident types by year by hall. The total of yearly calls is also represented.", 1L);
        helper.createDataset("Emergency Incidents By Fire Hall Summary", "Emergency incident summary counts for past five years by hall. The total monthly and yearly calls are represented.", 1L);
        helper.createDataset("Emergency Incidents by Type (Fire and Rescue Services)", "Incident types by month/year. The total and percentage of incidents of total calls is also represented. Only the current year is available in .csv.", 1L);
        helper.createDataset("Financial Disclosure Statements", "This form is a " +
                "mandated requirement of the Provincial government and is completed annually.\n" +
                "\n" +
                "The data elements on the form are:\n" +
                "\n" +
                "1) Name 2) Any assets the councillor owns 3) Any liabilities the councillor has " +
                "4) All income sources for the councillor 5) Real property owned by the " +
                "councillor that is not their primary residence.", 1L);
        helper.createDataset("Fire Incidents by Year", "Fire incidents by year. The total number of incidents is broken down into reportable to the Office of the Fire Commissioner and non reportable.", 1L);
        helper.createDataset("Grants (Awarded for 2016)", "A spreadsheet and " +
                "accompanying documents listing grants awarded for year 2016.\n" +
                "\n" +
                "Grant Categories;\n" +
                "\n" +
                "1) Festival Event Grants 2) Heritage Grants 3) Environmental Grants 4) Community" +
                " Grants 5) Arts and Culture Grants 6) Child Care Grants 6) City Partnership " +
                "Grants 7) Amateur Sports Grants\n" +
                "\n" +
                "For more information go to City Grants Page\n" +
                "\n" +
                "Supporting documents;\n" +
                "\n" +
                "City Grants Summary Sheet\n" +
                "\n" +
                "2016 City Partnership Grants.zip\n" +
                "\n" +
                "2016 Festival Grants.zip\n" +
                "\n" +
                "2016 Community Grants.zip\n" +
                "\n" +
                "2016 Arts and Culture Grants.zip\n" +
                "\n" +
                "2016 Amateur Sport Grants.zip\n" +
                "\n" +
                "2016 Heritage Grants.zip\n" +
                "\n" +
                "2016 Child Care Grant Program.zip\n" +
                "\n" +
                "2016 Environmental Grants.zip", 1L);
        helper.createDataset("Historical Development Statistics", "Statistics per " +
                "Hectare show a sample of four types of uses or content in a particular " +
                "block/area; the number of residences, the number of buildings, the floor space " +
                "ratio which is the ratio of a buildings total floor area to the size of the land" +
                " upon which it is built, and the number of parking spaces on property in the " +
                "area.\n" +
                "\n" +
                "Use in conjunction with the Block Reference Dataset.", 1L);
        helper.createDataset("ICBC Crash Data", "Lower mainland crashes\n" +
                "\n" +
                "See how many crashes are happening at intersections in New Westminster and " +
                "around the Lower Mainland.\n" +
                "\n" +
                "Click here to visit the ICBC Lower Mainland Crash website page!", 1L);
        helper.createDataset("Number of City Employees", "Financial Disclosure form completed annual by all elected officials. Number of city employees by year.", 1L);
        helper.createDataset("Orthophotography", "Aerial photography over the City of New Westminster", 1L);
        helper.createDataset("Schedule of Goods and Services (2015)", "Excel listing of all suppliers and service provides in the report period, plus the amount paid", 1L);
        helper.createDataset("Sidewalk Café Location (Sidewalk Encroachment " +
                "Agreements)", "List of the locations of all Sidewalk Encroachment Agreements", 1L);
        helper.createDataset("Statement of Financial Information (2015)", "Remuneration of City Employees & Council Members", 1L);
        helper.createDataset("Traffic Volumes", "Traffic volume counts at midblock points between the years 2006 and 2016 inclusive.", 1L);
        helper.createDataset("Workforce - New West Resident Commuting Patterns (NHS" +
                " 2011)", "This file contains information on the commuting patterns of workers who live in New Westminster (regardless of which municipality their place of work is located in). The information is from the 2011 National Household Survey and contains mode of transportation, time leaving for work, commute duration and commuting destinations. Also contains descriptive information about the data source files and notes about the use of the data.", 1L);
        helper.createDataset("Workforce - New West Worker Commuting Patterns (NHS " +
                "2011)", "Contains information on workers who work within the boundaries of the " +
                "City of New Westminster (regardless of their municipality of residence).\n" +
                "\n" +
                "Information is from the 2011 National Household Survey and includes mode of " +
                "transportation, time arriving at work, commute duration and commuting origin. " +
                "Also contains descriptive information about the data source files and notes " +
                "about the use of the data.", 1L);
        helper.createDataset("Workforce Profile (NHS 2011)", "2011 National Household Survey information on workers who work in New Westminster (regardless of municipality of residence). Information includes occupation, industry, employment income (before-tax), work activity, age and sex and education. Also contains descriptive information about the data source files and notes about the use of the data.", 1L);
    }

    public static void populateCityLand()
    {
        helper.createDataset("Block Reference File", "The blocks " +
                "correspond to a division of the City into about 400 blocks, set up by the City " +
                "Planner in about 1970. The purpose of these geographic descriptions was to " +
                "enable more rapid tallying of information by subareas of the City. The " +
                "geographic subdivision keys would provide easier selection of which properties " +
                "to include in a run for a report without having to rely on property folio " +
                "designations which are subject to change, consolidation and subdivision.\n" +
                "\n" +
                "Block reference file used with \"Historical Development Statistics\" and " +
                "\"Landuse Percentages by Block\" datasets", 2L);
        helper.createDataset("Building Age", "The age of most buildings in the City (year it was built) as well as some historical data such as the Building Name, Developer/Builder, Architect/Designer and year the building has been moved if relevant and available.", 2L);
        helper.createDataset("Building Attributes", "Building development specifics including the number of floors above and below ground, the number of residential units, square footage, size of the footprint and site coverage, and address.", 2L);
        helper.createDataset("Building Footprints", "Outlines of buildings. All primary buildings such as residential and commerical are included.", 2L);
        helper.createDataset("City Boundaries", "City of New Westminster Boundaries.", 2L);
        helper.createDataset("City Facility Sites", "No Description Available", 2L);
        helper.createDataset("City Owned Property", "Parcels of property currently owned by the Corporation of the City of New Westminster.", 2L);
        helper.createDataset("Contours", "1 meter intervals", 2L);
        helper.createDataset("Fire and Rescue Services Buildings", "No Description Available", 2L);
        helper.createDataset("Heritage Register", "Official listing of properties deemed to have heritage value. Visit the Heritage Register Website Viewer.", 2L);
        helper.createDataset("Heritage Resource Inventory", "Complete unofficial listing of properties deemed to have heritage value, demolished and standing buildings. Visit the Heritage Resource Inventory Website Viewer!", 2L);
        helper.createDataset("Hospital Buildings", "No Description Available", 2L);
        helper.createDataset("Land Use", "Land use represents what a parcel of land is currently being used for (i.e., the land parcel’s primary use). The land use shown in this layer does not necessarily reflect the zoning or the OCP designation of the land.", 2L);
        helper.createDataset("Land Use Industrial", "Land use represents what a parcel of land is currently being used for (i.e., the land parcel’s primary use). The land use shown in this layer does not necessarily reflect the zoning or the OCP designation of the land.", 2L);
        helper.createDataset("Landuse Percentages by block", "The Landuse " +
                "Percentages show what proportion of a block/area has a particular use (e.g., " +
                "being used for Commercial purposes or Single Family Residences).\n" +
                "\n" +
                "Use in conjunction with the Block Reference Dataset", 2L);
        helper.createDataset("Neighbourhoods Boundaries", "These new boundaries are used for contemporary planning functions and are the basis for most of the statistics used in recent Census data published by the City of New Westminster. The boundaries for all neighbourhoods except for Downtown, North Arm North and Queens Park are the same for the redefined neighbourhood boundaries as in the original neighbourhood boundaries. ", 2L);
        helper.createDataset("Parcel Blocks", "Block outlines of contiguous aggregated parcels.", 2L);
        helper.createDataset("Park Structures", "Park Structure data will include " +
                "the structure name, structure type, quantity, monument dedication inscription, " +
                "furnishing photo graph (as available) park name and/or location. The types of " +
                "park structures included in the collection are • Bleachers • drinking fountains " +
                "• Park Lighting • Monuments • Basketball hoops • Horticultural Planting Areas • " +
                "Picnic Tables\n" +
                "\n" +
                "Monument dedication inscriptions were provided to the City for publically " +
                "displayed on the monument, and as such the City has approval for the release. " +
                "The inscription includes name, potentially a date range and inscription. ", 2L);
        helper.createDataset("Police Buildings", "No Description Available", 2L);
        helper.createDataset("Projects on the Go", "Current applications for rezoning, development permit and heritage revitalization agreement projects currently being processed by the City, including application status, architect/ developer information, and staff contact.", 2L);
        helper.createDataset("School Buildings", "No Description Available", 2L);
        helper.createDataset("School Catchment Boundaries", "Primary, Middle and Secondary School Boundaries.", 2L);
        helper.createDataset("School Sites", "No Description Available", 2L);
        helper.createDataset("SkyTrain Stations", "SkyTrain Stations within New Westminster shown as footprints of the structure shapes.", 2L);
        helper.createDataset("Survey Monuments", "For more information see Mascot at GeoBC Reference Systems and Survey Monuments.", 2L);
        helper.createDataset("Tree Inventory - East", "Street trees do more than " +
                "beautify our City and create community pride. Street trees have been " +
                "scientifically proven to: save energy by reduce heating or cooling costs for " +
                "buildings they cover calm traffic clean air filter dust absorb sound cool area " +
                "under tree and absorb humidity provide habitats for birds, mammals and insects\n" +
                "\n" +
                "Parks staff select street trees based on established research to ensure the " +
                "trees are viable without damaging public or private property and are resilient " +
                "to disease and pests. Street trees generally have the following characteristics:" +
                " Small to medium size (20 – 35 feet at maturity) Raised crown to provide maximum" +
                " clearance between the sidewalk and lower branches Non-aggressive root systems " +
                "Growth habits that are compatible with streetscapes (i.e. trees with upright " +
                "growth habits are used in narrow spaces) Ornamental characteristics (i.e. bark, " +
                "fall colour, flowers, etc.) that enhance the neighbourhood.", 2L);
        helper.createDataset("Tree Inventory - West", "Street trees do more than " +
                "beautify our City and create community pride. Street trees have been " +
                "scientifically proven to: save energy by reduce heating or cooling costs for " +
                "buildings they cover calm traffic clean air filter dust absorb sound cool area " +
                "under tree and absorb humidity provide habitats for birds, mammals and insects\n" +
                "\n" +
                "Parks staff select street trees based on established research to ensure the " +
                "trees are viable without damaging public or private property and are resilient " +
                "to disease and pests. Street trees generally have the following characteristics:" +
                " Small to medium size (20 – 35 feet at maturity) Raised crown to provide maximum" +
                " clearance between the sidewalk and lower branches Non-aggressive root systems " +
                "Growth habits that are compatible with streetscapes (i.e. trees with upright " +
                "growth habits are used in narrow spaces) Ornamental characteristics (i.e. bark, " +
                "fall colour, flowers, etc.) that enhance the neighbourhood.", 2L);
        helper.createDataset("Zoning", "The City of New Westminster Zoning Bylaw No" +
                ". 6680 was adopted by Council September 17, 2001. Subsequent amendments to the " +
                "Zoning Bylaw are consolidated for convenience only. For accurate interpretation," +
                " the public is encouraged to consult the Official Zoning Bylaw (including maps " +
                "and amendments) available for viewing at City Hall in the Planning Division or " +
                "Legislative Services Department.\n" +
                "\n" +
                "For more information: http://www.newwestcity.ca/city_hall/bylaws/articles250.php", 2L);
    }

    public static void populateUndergroundData()
    {
        helper.createDataset("Oil Tanks (Removed/Decommissioned)", "The number of underground storage tanks that are active, removed, or outstanding in the removal process, by year.", 3L);
        helper.createDataset("Sewer Catchbasins", "No Description Available", 3L);
        helper.createDataset("Sewer Culverts", "No Description Available", 3L);
        helper.createDataset("Sewer Ditches", "No Description Available", 3L);
        helper.createDataset("Sewer Mains", "No Description Available", 3L);
        helper.createDataset("Sewer Maintenance Holes", "No Description Available", 3L);
        helper.createDataset("Water Pressure Zones", "This polygon feature class represents each water pressure zone in the City of New Westminster water distribution system. The data was developed to represent the location of water pressure zones for the purpose of mapping, analysis, planning and maintenance of utilities. The accuracy of this data varies and should not be used for precise measurements or calculations.", 3L);
        helper.createDataset("Water Quality Data", "A hydrant is an outlet from a " +
                "fluid main often consisting of an upright pipe with a valve attached from which " +
                "fluid (e.g. water or fuel) can be tapped. This data set presents the raw data " +
                "from which our Annual Water Quality report is generated. For full context for " +
                "the data please refer to the report.\n" +
                "\n" +
                "NWR Comp 2015.xlsm - Monthly bacteriological analysis of portable water " +
                "samples\n" +
                "\n" +
                "NWR Numbers 2015.xlsm - Monthly samples for coliform bacteria\n" +
                "\n" +
                "NWR By-station 2015.xlsm - Full year water quality testing by station (addresses" +
                " given are locations of the sampling station)\n" +
                "\n" +
                "NWR HPC 2015.xlsm - Monthly heterotrophic plate count\n" +
                "\n" +
                "NWR 4Q DBP.xlsm - 4th quarter disinfectant by product reports", 3L);
        helper.createDataset("Water Valves", "A device that regulates the flow of water.", 3L);
        helper.createDataset("Watermains", "A principal pipe in a system of pipes for conveying water, especially one installed underground.", 3L);
    }

    public static void populateMiscellaneous()
    {
        helper.createDataset("Community Conversation on Housing Comments " +
                "(Our City 2014)", "Got to https://www.newwestcity.ca/ourcity for more details", 4L);
        helper.createDataset("Parcels", "No Description Available", 4L);
        helper.createDataset("Public Art", "No Description Available", 4L);
        helper.createDataset("Riparian", "No Description Available", 4L);
    }

    public static void populatePublicUtilities()
    {
        helper.createDataset("Accessible Public Washrooms", "Listing of all the accessible washrooms that are available within the City.", 5L);
        helper.createDataset("Alternative Fuels and Electric Charging Stations", "Electric vehicles are an environmentally friendly mode of transportation. As cleaner emission vehicles gain momentum across the lower mainland, the City of New Westminster is putting itself on the map alongside leading municipalities by incorporating electric vehicles into the City's automotive fleet and installing electric vehicle charging stations in the community.\n" +
                "\n" +
                "For a map of EV charging stations and their availability, visit Go Electric " +
                "Stations.", 5L);
        helper.createDataset("Bus Stops", "Bus Stop locations within New Westminster noting which are accessible.", 5L);
        helper.createDataset("Cemeteries", "No Description Available", 5L);
        helper.createDataset("Community Service Assets", "A listing of community services and supports. More specifically, it includes information on emergency, transitional and supportive housing; transition and second stage housing for women; addiction and mental health services; drop-in and meal programs; education and job training opportunities; and government services.", 5L);
        helper.createDataset("Drinking Fountains", "No Description Available", 5L);
        helper.createDataset("Off Leash Dog Areas", "No Description Available", 5L);
        helper.createDataset("Park Benches and Dedications", "Park benches locations throughout the city. Green: Undedicated benches Purple : Dedicated benches", 5L);
        helper.createDataset("Park Greenspaces", "No Description Available", 5L);
        helper.createDataset("Parking Pay Stations", "Identifies the locations of all multi-space digital pay stations for parking in the City.", 5L);
        helper.createDataset("Parks", "No Description Available", 5L);
        helper.createDataset("Playgrounds", "Includes the playgrounds within the parks in the City and the types of equipment available for play.", 5L);
        helper.createDataset("SkyTrain Stations Points", "SkyTrain Stations within New Westminster shown as point locations.", 5L);
        helper.createDataset("Sports Fields", "Sports Fields will include various types of activity fields including those used for softball, soccer, rugby, football, and lacrosse.", 5L);
        helper.createDataset("Wheelchair Ramps", "", 5L);
    }

    public static void populateStreetInformation()
    {
        helper.createDataset("Addresses", "A list of addresses for the City of New Westminster.", 6L);
        helper.createDataset("Bike Routes", "This dataset contains bike routes including planned and current bikeways, on-street and off-street, as well as dedicated lanes.", 6L);
        helper.createDataset("Bus Routes", "Bus Routes within New Westminster.", 6L);
        helper.createDataset("Greenways", "Greenways provide important cycling routes across the City connecting from one community to another and between major parks.", 6L);
        helper.createDataset("Intersections", "The junctions at-grade of two or more roads either meeting or crossing.", 6L);
        helper.createDataset("Park Trails", "", 6L);
        helper.createDataset("Railways", "", 6L);
        helper.createDataset("Regulatory Signs", "Regulatory street signs which also include Do Not Enter and 3 and 4 Way tabs.", 6L);
        helper.createDataset("School Walking Routes", "Walking to school promotes healthy and safe communities benefiting children, families, and the earth.", 6L);
        helper.createDataset("SkyTrain Centreline", "", 6L);
        helper.createDataset("Speed Signs", "These street signs include Speed Signs and Speed Tabs.", 6L);
        helper.createDataset("Street Features", "", 6L);
        helper.createDataset("Street Names", "List of all current in-use street names used within the City.", 6L);
        helper.createDataset("Street Network", "Street centerlines and road classification", 6L);
        helper.createDataset("Traffic Controllers/Signals", "", 6L);
        helper.createDataset("Truck Routes", "", 6L);
        helper.createDataset("Warning Signs", "Warning Street Signs include Object Markers, Playground Ahead, Speed Bumps, Neighbourhood Speed Humps, No Exits, School Areas, and Misc Warning Signs.", 6L);
        helper.createDataset("Water Hydrants", "A hydrant is an outlet from a fluid main often consisting of an upright pipe with a valve attached from which fluid (e.g. water or fuel) can be tapped.", 6L);
        helper.createDataset("Webcam Links", "Active webcam locations in New Westminster.", 6L);
    }

    public static void clearDatabase()
    {
        DaoHelper.categoriesDao.deleteAll();
        DaoHelper.datasetsDao.deleteAll();
    }
}
