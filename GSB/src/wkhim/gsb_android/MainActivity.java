package wkhim.gsb_android;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import java.util.List;
import wkhim.gsb_android.modele.DAO;

public class MainActivity extends ListActivity {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        List<String> lesDeps = DAO.getLesDeps();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lesDeps);
        setListAdapter(adapter);
    }
}
