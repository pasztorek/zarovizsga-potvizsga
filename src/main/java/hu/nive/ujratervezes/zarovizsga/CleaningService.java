package hu.nive.ujratervezes.zarovizsga;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CleaningService {

    private List<Cleanable> properties = new ArrayList<>();


    public void add(Cleanable cleanable) {
        properties.add(cleanable);

    }

    public List<Cleanable> getCleanables() {
        return properties;
    }

    public int cleanAll() {
        int result = 0;
        List<Cleanable> propref = new ArrayList<>(properties);

        for (int i = 0; i < properties.size(); i++) {
            result = result + properties.get(i).clean();
        }
        properties.removeAll(properties);
        return result;
    }

    public int cleanOnlyOffices() {
        int result = 0;
        Iterator<Cleanable> iterator = properties.iterator();

        while (iterator.hasNext()) {

            Cleanable prop = iterator.next();
            if (prop instanceof Office) {
                result = result + prop.clean();
                iterator.remove();
            }
        }
        return result;
    }

    public List<Cleanable> findByAddressPart(String address) {
        List<Cleanable> result = new ArrayList<>();

        for (Cleanable prop : properties) {
            if (prop.getAddress().contains(address)) {
                result.add(prop);
            }
        }

        return result;
    }

    public String getAddresses() {
        String result = "";


        for (Cleanable prop : properties) {
            result = result + prop.getAddress() + ", ";
        }

        if (!result.equals("")) {
           result = result.substring(0, result.length() - 2);
        }

        return result;
    }
}


