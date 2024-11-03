package org.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import spark.Request;
import org.model.Companies;
import org.proto.Server3;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.lang.reflect.Type;

public class Converters {
    public Converters() {}

    private Gson gson = new GsonBuilder().create();

    public Companies ReqToCompanies (Request req){
        System.out.println("ReqToCompanies");
        String companyName = req.queryParams("companyName");
        String companyAvatarURL = req.queryParams("companyAvatarURL");
        String website = req.queryParams("website");
        String email = req.queryParams("email");
        Companies company = new Companies(companyName, companyAvatarURL, website, email);

        String companiesIDParam = req.queryParams("companiesID");

        if (companiesIDParam != null && !companiesIDParam.isEmpty()) {
            try {
                int companiesID = Integer.parseInt(companiesIDParam);
                company.setCompaniesID(companiesID);
            } catch (NumberFormatException e) {
                System.out.println("Không tìm được companiesID");
            }
        }

        String activeRecruitersGson = req.queryParams("activeRecruiters");
        Type type = new TypeToken<ConcurrentHashMap<Integer, Boolean>>(){}.getType();
        ConcurrentHashMap<Integer, Boolean> activeRecruiters = gson.fromJson(activeRecruitersGson, type);
        company.setActiveRecruiters(activeRecruiters);

        String activeLocationsGson = req.queryParams("activeLocations");
        type = new TypeToken<ConcurrentHashMap<Integer, Boolean>>(){}.getType();
        ConcurrentHashMap<Integer, Boolean> activeLocations = gson.fromJson(activeLocationsGson, type);
        company.setActiveLocations(activeLocations);
        return company;
    }

    public Server3.CompanyFullInfo CompaniesToProto(Companies company){
        Server3.CompanyFullInfo.Builder builder = Server3.CompanyFullInfo.newBuilder()
                .setCompanyName(company.getCompanyName())
                .setCompanyAvatarURL(company.getCompanyAvatarURL())
                .setWebsite(company.getWebsite())
                .setEmail(company.getEmail());

        if(company.getCompaniesID() != null)
            builder.setCompaniesID(company.getCompaniesID());
        if(company.getActiveRecruiters() != null){
            for (Map.Entry<Integer, Boolean> entry : company.getActiveRecruiters().entrySet()) {
                builder.putActiveRecruiters(entry.getKey(), entry.getValue());
            }
        }

        if(company.getActiveLocations() != null){
            for (Map.Entry<Integer, Boolean> entry : company.getActiveLocations().entrySet()) {
                builder.putActiveLocations(entry.getKey(), entry.getValue());
            }
        }
        System.out.println("CompaniesToProto");

        return builder.build();
    }
}
