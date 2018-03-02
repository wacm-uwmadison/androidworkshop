package me.ancyphilip.dice;

import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ancyphilip on 3/2/18.
 */

public class SpinnerListener implements AdapterView.OnItemSelectedListener {
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        /*
        This is to get the linear view. Activities have access to the entire layout but in listeners
        'view' param refers to the element being listened to.
        So to get sibling elements, we first get the parent.
        */
        View parent = (View) view.getParent().getParent();

        Map<String, Double> conversionFactors = new HashMap<String, Double>() {{
            put("KG_GRAM", 1000.0);
            put("GRAM_KG", 1.0 / 1000);
            put("METER_KM", 1.0 / 1000);
            put("METER_YARD", 1.09361);
            put("FEET_INCH", 12.0);
            put("FEET_YARD", 0.33);
            put("YARD_FEET", 3.0);
            put("INCH_YARD", 0.0277);
            put("YARD_INCH", 36.0);

        }};

        String fromUnit = "";
        String toUnit = "";
        String fromUnitInput = ((EditText) parent.findViewById(R.id.unit1)).getText().toString();

        /*
            Get values of each spinner
         */
        fromUnit = ((AdapterView) (parent.findViewById(R.id.unit1_list))).getSelectedItem().toString();
        toUnit = ((AdapterView) (parent.findViewById(R.id.unit2_list))).getSelectedItem().toString();

        /*
            Convert!
         */
        if (!fromUnit.isEmpty() && !toUnit.isEmpty() && !fromUnitInput.isEmpty()) {
            // we are not checking for validity!
            double fromUnitValue = Double.parseDouble(fromUnitInput);
            if (conversionFactors.containsKey(fromUnit + "_" + toUnit)) {
                double conversionFactor = conversionFactors.get(fromUnit + "_" + toUnit);
                ((TextView) parent.findViewById(R.id.convert_result)).setText((fromUnitValue * conversionFactor) + "");
            } else {
                Toast.makeText(view.getContext(), "Can't Convert", Toast.LENGTH_SHORT).show();
            }
        }
    }


    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
