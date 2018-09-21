package materialdesign.interra.com.chips;


import android.os.Bundle;
import android.support.design.button.MaterialButton;
import android.support.design.chip.Chip;
import android.support.design.chip.ChipDrawable;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;


public class MainActivity extends AppCompatActivity {

    boolean lightCheck = true;
    boolean doorCheck = true;
    boolean curtainCheck = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final NestedScrollView container = findViewById(R.id.container);
        MaterialButton mealOrder = findViewById(R.id.orderModalSheet);
        MaterialButton roomService = findViewById(R.id.roomService);
        MaterialButton message = findViewById(R.id.message);

        roomService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(container, "Your request is sent", Snackbar.LENGTH_LONG).setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }).show();
            }
        });

        mealOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final MealOrder order = new MealOrder();
                order.show(getSupportFragmentManager(), "modal sheet");
            }
        });

        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendText sendText = new SendText();
                sendText.show(getSupportFragmentManager(), "sheet");
            }
        });

        final Chip light = findViewById(R.id.light);
        light.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lightCheck) {
                    light.setText(R.string.turn_off_lights);
                    light.setChipIconResource(R.drawable.ic_brightness_7_black_24dp);
                    lightCheck = false;
                }
                else {
                    light.setText(R.string.turn_on_lights);
                    light.setChipIconResource(R.drawable.ic_brightness_5_black_24dp);
                    lightCheck = true;
                }
            }
        });

        final Chip door = findViewById(R.id.door);
        door.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (doorCheck) {
                    door.setText(R.string.unlock);
                    door.setChipIconResource(R.drawable.ic_lock_open_black_24dp);
                    doorCheck = false;
                }
                else {
                    door.setText(R.string.lock_the_door);
                    door.setChipIconResource(R.drawable.ic_lock_outline_black_24dp);
                    doorCheck = true;
                }
            }
        });

        final Chip curtain = findViewById(R.id.curtain);
        curtain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (curtainCheck) {
                    curtain.setText(R.string.close_curtain);
                    curtainCheck = false;
                }
                else {
                    curtain.setText(R.string.open_the_curtain);
                }
            }
        });
    }
}
