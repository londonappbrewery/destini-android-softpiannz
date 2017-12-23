package com.londonappbrewery.destini;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private enum Answer {
        ANSWER_1, ANSWER_2
    }
    // TODO: Steps 4 & 8 - Declare member variables here:
    private TextView mStoryTextView;
    private Button mTopButton;
    private Button mBottomButton;

    private Button mStartButton;

    private int mStoryIndex = 1;

    private StoryContents[] mStoryContents = new StoryContents[] {
            new StoryContents(-1, -1, -1),  // dummy elements in order to start index from 1
            new StoryContents(R.string.T1_Story, R.string.T1_Ans1, R.string.T1_Ans2),
            new StoryContents(R.string.T2_Story, R.string.T2_Ans1, R.string.T2_Ans2),
            new StoryContents(R.string.T3_Story, R.string.T3_Ans1, R.string.T3_Ans2),
            new StoryContents(R.string.T4_End, -1, -1),
            new StoryContents(R.string.T5_End, -1, -1),
            new StoryContents(R.string.T6_End, -1, -1)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryTextView = (TextView) findViewById(R.id.storyTextView);
        mTopButton = (Button) findViewById(R.id.buttonTop);
        mBottomButton = (Button) findViewById(R.id.buttonBottom);
        mStartButton = (Button) findViewById(R.id.buttonStart);

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateStory(Answer.ANSWER_1);
            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mBottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateStory(Answer.ANSWER_2);
            }
        });

        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mStoryIndex = 1;

                mStoryTextView.setText(mStoryContents[mStoryIndex].getStory());
                mTopButton.setText(mStoryContents[mStoryIndex].getAnswer1());
                mBottomButton.setText(mStoryContents[mStoryIndex].getAnswer2());

                mStartButton.setVisibility(View.GONE);

                mStoryTextView.setVisibility(View.VISIBLE);
                mTopButton.setVisibility(View.VISIBLE);
                mBottomButton.setVisibility(View.VISIBLE);
            }
        });
    }

    private void updateStory(Answer answerPath) {
        if (answerPath == Answer.ANSWER_1) {
            if (mStoryIndex == 1) {
                mStoryIndex = 3;
            } else if (mStoryIndex == 2) {
                mStoryIndex = 3;
            } else if (mStoryIndex == 3) {
                mStoryIndex = 6;
            }
        } else if (answerPath == Answer.ANSWER_2) {
            if (mStoryIndex == 1) {
                mStoryIndex = 2;
            } else if (mStoryIndex == 2) {
                mStoryIndex = 4;
            } else if (mStoryIndex == 3) {
                mStoryIndex = 5;
            }
        }

        if (mStoryContents[mStoryIndex].getStory() == -1) {
            mStoryTextView.setVisibility(View.GONE);
        } else {
            mStoryTextView.setText(mStoryContents[mStoryIndex].getStory());
        }
        if (mStoryContents[mStoryIndex].getAnswer1() == -1) {
            mTopButton.setVisibility(View.GONE);
        } else {
            mTopButton.setText(mStoryContents[mStoryIndex].getAnswer1());
        }
        if (mStoryContents[mStoryIndex].getAnswer2() == -1) {
            mBottomButton.setVisibility(View.GONE);
        } else {
            mBottomButton.setText(mStoryContents[mStoryIndex].getAnswer2());
        }

        if (mStoryIndex == 4 || mStoryIndex == 5 || mStoryIndex == 6) {
            mStartButton.setVisibility(View.VISIBLE);
        }
    }
}
