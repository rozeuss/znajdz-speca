package com.example.model;


import com.example.model.Client.Client;
import com.example.model.Client.ClientRepository;
import com.example.model.Company.Company;
import com.example.model.Company.CompanyRepository;
import com.example.model.Job.Job;
import com.example.model.Job.JobRepository;
import com.example.model.Specialization.Specialization;
import com.example.model.Specialization.SpecializationRepository;
import com.example.model.Tag.Tag;
import com.example.model.Tag.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

@Component
public class DBTestData implements CommandLineRunner {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private SpecializationRepository specializationRepository;

    @Override
    public void run(String... args) throws Exception {


        String[] localizations = generateLocations();
        List<Date[][]> dates = generateDates();
        generateClients();
        generateCompanies();
        generateActualTags();
        generateJobs(dates, localizations);
        generateSpecsForJobs();
        generateSpecsForCompanies();
    }

    private Date[][] fillDateTable(Date startDate) {

        Date[][] dateTable = new Date[4][7];
        Calendar calendar = Calendar.getInstance();
        Date currentDate;

        if(startDate == null) {
            currentDate = new Date(calendar.getTime().getTime());
        }
        else {
            currentDate = startDate;
            calendar.setTime(startDate);
        }

        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 7; j++) {
                dateTable[i][j] = currentDate;
                calendar.add(Calendar.DAY_OF_MONTH, 1);
                currentDate = new Date(calendar.getTimeInMillis());
            }
        }

        return dateTable;
    }

    private Date getRandomDate(Date[][] dateTable) {

        Random random = new Random();
        int week = random.nextInt(4);
        int day = random.nextInt(7);

        return dateTable[week][day];
    }

    private void fillLocalsTable(String[] localsTable) {

        localsTable[0] = "Warszawa";
        localsTable[1] = "Płock";
        localsTable[2] = "Gdynia";
        localsTable[3] = "Sopot";
        localsTable[4] = "Katowice";
        localsTable[5] = "Zakopane";
        localsTable[6] = "Wrocław";
        localsTable[7] = "Lublin";
        localsTable[8] = "Zamość";
        localsTable[9] = "Szczecin";
        localsTable[10] = "Gdańsk";
        localsTable[11] = "Toruń";
        localsTable[12] = "Pruszków";
        localsTable[13] = "Kielce";
        localsTable[14] = "Zabrze";
    }

    private void generateTestTags() {

        Character name = 'a';
        int tagsNumber = 10;
        for(int i = 0; i < tagsNumber; i++) {

            Tag tag = new Tag();
            tag.setName(name.toString());
            tagRepository.save(tag);
            name++;
        }

    }

    private void generateActualTags() {

        List<Tag> tags = new ArrayList<>();

        tags.add(new Tag("Architekt"));
        tags.add(new Tag("Dekarz"));
        tags.add(new Tag("Elektryka"));
        tags.add(new Tag("Garaż"));
        tags.add(new Tag("Glazura"));
        tags.add(new Tag("Hydraulika"));
        tags.add(new Tag("Klimatyzacja"));
        tags.add(new Tag("Kuchnia"));
        tags.add(new Tag("Łazienka"));
        tags.add(new Tag("Malarz"));
        tags.add(new Tag("Murarstwo"));
        tags.add(new Tag("Ogrodnictwo"));
        tags.add(new Tag("Ogrodzenie"));
        tags.add(new Tag("Ogrzewanie"));
        tags.add(new Tag("Okna"));
        tags.add(new Tag("Oświetlenie"));
        tags.add(new Tag("Panele"));
        tags.add(new Tag("Prace ziemne"));
        tags.add(new Tag("Przebudowa"));
        tags.add(new Tag("Schody"));
        tags.add(new Tag("Sprzątanie"));
        tags.add(new Tag("Stolarz"));
        tags.add(new Tag("Szafy"));
        tags.add(new Tag("Zabudowa"));
        tags.add(new Tag("Złota rączka"));

        tagRepository.save(tags);

    }

    private void generateClients() {

        Client client = new Client();
        client.setName("Jan");
        client.setLastname("Kowalski");
        client.setEmail("jankowalski@example.com");
        client.setPassword("12345678");
        client.setPhoneNumber("123456789");
        clientRepository.save(client);

        Client client1 = new Client();
        client1.setName("Adam");
        client1.setLastname("Malinowski");
        client1.setEmail("adammalinowski@example.com");
        client1.setPassword("12345678");
        clientRepository.save(client1);

        Client client2 = new Client();
        client2.setName("Piotr");
        client2.setLastname("Leszczyński");
        client2.setEmail("piotrleszczynski@example.com");
        client2.setPassword("12345678");
        clientRepository.save(client2);

        Client client3 = new Client();
        client3.setName("Karolina");
        client3.setLastname("Zawadzka");
        client3.setEmail("karolinazawadzka@example.com");
        client3.setPassword("12345678");
        clientRepository.save(client3);

        Client client4 = new Client();
        client4.setName("Marzena");
        client4.setLastname("Wtorek");
        client4.setEmail("marzenawtorek@example.com");
        client4.setPassword("12345678");
        clientRepository.save(client4);

    }

    private void generateCompanies() {

        Random random = new Random();

        Company company = new Company();
        company.setName("Kowalscy");
        company.setAreaRange(25);
        company.setLocalization("Warszawa");
        company.setEmail("kowalscy@example.com");
        company.setPassword("12345678");
        company.setRating(random.nextFloat()*5.0f);
        company.setNumberJobs(1 + random.nextInt(25));
        company.setNumberOpinions(random.nextInt(company.getNumberJobs() + 1));
        companyRepository.save(company);

        Company company2 = new Company();
        company2.setName("Budex");
        company2.setAreaRange(75);
        company2.setLocalization("Poznań");
        company2.setEmail("budex@example.com");
        company2.setPassword("12345678");
        company2.setRating(random.nextFloat()*5.0f);
        company2.setNumberJobs(1 + random.nextInt(25));
        company2.setNumberOpinions(random.nextInt(company2.getNumberJobs() + 1));
        companyRepository.save(company2);

        Company company3 = new Company();
        company3.setName("Janusz");
        company3.setAreaRange(62);
        company3.setLocalization("Katowice");
        company3.setEmail("januszcompany@example.com");
        company3.setPassword("12345678");
        company3.setRating(random.nextFloat()*5.0f);
        company3.setNumberJobs(1 + random.nextInt(25));
        company3.setNumberOpinions(random.nextInt(company3.getNumberJobs() + 1));
        companyRepository.save(company3);

        Company company4 = new Company();
        company4.setName("Impex");
        company4.setAreaRange(40);
        company4.setLocalization("Gdynia");
        company4.setEmail("impex@example.com");
        company4.setPassword("12345678");
        company4.setRating(random.nextFloat()*5.0f);
        company4.setNumberJobs(1 + random.nextInt(25));
        company4.setNumberOpinions(random.nextInt(company4.getNumberJobs() + 1));
        companyRepository.save(company4);

        Company company5 = new Company();
        company5.setName("Era-Box");
        company5.setAreaRange(120);
        company5.setLocalization("Wrocław");
        company5.setEmail("erabox@example.com");
        company5.setPassword("12345678");
        company5.setRating(random.nextFloat()*5.0f);
        company5.setNumberJobs(1 + random.nextInt(25));
        company5.setNumberOpinions(random.nextInt(company5.getNumberJobs() + 1));
        companyRepository.save(company5);

    }

    private void generateJobs(List<Date[][]> dates, String[] localizations) {

        int jobsNumber = 30;

        Calendar calendar = Calendar.getInstance();
        Random random = new Random();

        for(int i = 0; i < jobsNumber; i++) {
            Job job = new Job();
            Client client5 = clientRepository.findById(1+random.nextInt(4));
            job.setClient(client5);
            int ascii = 'a' + random.nextInt(15);
            char character = (char)ascii;
            job.setTitle(new StringBuilder().append(character).toString());
            job.setVisible(true);
            job.setBeginDate(getRandomDate(dates.get(0)));
            job.setEndDate(getRandomDate(dates.get(1)));
            job.setAddedAt(new Date(calendar.getTime().getTime()));
            job.setLocalization(localizations[random.nextInt(15)]);
            jobRepository.save(job);
        }

    }

    private List<Date[][]> generateDates() {

        Date[][] beginDateTable = null;
        Date[][] endDateTable = null;

        beginDateTable = fillDateTable(null);

        int bdtFirstIndex = beginDateTable.length;
        int bdtSecondIndex = beginDateTable[0].length;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(beginDateTable[bdtFirstIndex-1][bdtSecondIndex-1]);
        calendar.add(Calendar.DAY_OF_MONTH, 1);

        endDateTable = fillDateTable(new Date(calendar.getTime().getTime()));
        calendar = Calendar.getInstance();

        List<Date[][]> dates = new ArrayList<>();
        dates.add(beginDateTable);
        dates.add(endDateTable);

        return dates;
    }

    private String[] generateLocations() {

        int localsNumber = 15;
        String[] localizations = new String[localsNumber];
        fillLocalsTable(localizations);

        return localizations;
    }

    private void generateSpecsForJobs() {

        List<Job> jobs = jobRepository.findAll();
        Random random = new Random();

        for(int i = 0; !jobs.isEmpty(); i++) {

            Job job = jobs.get(0);
            jobs.remove(0);
            int tagsInJob = 3 + random.nextInt(4);
            List<Tag> tagList = tagRepository.findAll();

            for(int j = 0; j < tagsInJob; j++) {

                Tag tag = tagList.get(random.nextInt(tagList.size()));
                tagList.remove(tag);
                Specialization specialization = new Specialization(tag, job);
                specializationRepository.save(specialization);
            }
        }

    }

    private void generateSpecsForCompanies() {

        List<Company> companies = companyRepository.findAll();
        Random random = new Random();

        for(int i = 0; !companies.isEmpty(); i++) {

            Company company = companies.get(0);
            companies.remove(0);
            int tagsInCompany = 2 + random.nextInt(4);
            List<Tag> tagList = tagRepository.findAll();

            for(int j = 0; j < tagsInCompany; j++) {

                Tag tag = tagList.get(random.nextInt(tagList.size()));
                tagList.remove(tag);
                Specialization specialization = new Specialization(tag, company);
                specializationRepository.save(specialization);
            }
        }

    }

}
