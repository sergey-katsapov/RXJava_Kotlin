package jellgo_bytes.rxjavasimple.data;

import android.content.Context;
import android.os.SystemClock;

import java.util.ArrayList;
import java.util.List;

public class RestClient {
    private Context mContext;

    public RestClient(Context context) {
        mContext = context;
    }

    private List<String> createPerson(){
        List<String> persons = new ArrayList<>();
        persons.add("Sergey Katsapov");
        persons.add("Alex Ivanov");
        persons.add("Ioanna Plotinskaya");
        persons.add("Nastya Ivleeva");
        persons.add("Igor Kazakevich");
        persons.add("Lolita Ryankina");
        persons.add("Ivan Klimov");
        persons.add("Sergey Andreev");
        persons.add("Vika Kolipakova");
        return persons;
    }

    public List<String> getPersons(){
        SystemClock.sleep(5000);
        return createPerson();
    }
}
