package viewdraw.propertyanimation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    Button button,button2,button3,button4,button5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView= (ImageView) findViewById(R.id.img);
        button= (Button) findViewById(R.id.button1);
        button2= (Button) findViewById(R.id.button2);
        button3= (Button) findViewById(R.id.button3);
        button4= (Button) findViewById(R.id.button4);
        button5= (Button) findViewById(R.id.button5);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator scaleY = ObjectAnimator.ofFloat(imageView, "scaleY", 0, 3,1);
                scaleY.setDuration(2000);
                scaleY.start();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator alpha = ObjectAnimator.ofFloat(imageView, "alpha", 1f, 0f);
                alpha.setDuration(2000);
                alpha.start();
            }
        });


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator rotation = ObjectAnimator.ofFloat(imageView, "rotation", 0, 360);
                rotation.setDuration(2000);
                rotation.start();
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator alpha = ObjectAnimator.ofFloat(imageView, "translationX", 0f, 500f);
                alpha.setDuration(2000);
                alpha.start();
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator moveIn = ObjectAnimator.ofFloat(imageView, "translationX", -500f, 0f);
                ObjectAnimator rotate = ObjectAnimator.ofFloat(imageView, "rotation", 0f, 360f);
                ObjectAnimator fadeInOut = ObjectAnimator.ofFloat(imageView, "alpha", 1f, 0f, 1f);
                AnimatorSet animSet = new AnimatorSet();
                animSet.play(rotate).with(fadeInOut).after(moveIn);
                animSet.setDuration(5000);
                animSet.start();
                animSet.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        Toast.makeText(getApplicationContext(),"动画开始了",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        Toast.makeText(getApplicationContext(),"动画结束了",Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {
                    }
                });
            }
        });

    }
}
