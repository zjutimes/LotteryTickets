package com.betterzw.lotterytickets.main;


import android.support.design.widget.TabLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.betterzw.lotterytickets.R;
import com.betterzw.lotterytickets.api.LotteryBaseData;
import com.betterzw.lotterytickets.api.Repo;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by zhengwu on 4/11/18.
 */
public class HomeAdapter extends BaseQuickAdapter<LotteryBaseData.LotteryData, BaseViewHolder> {

    public HomeAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(final BaseViewHolder helper, LotteryBaseData.LotteryData item) {

        helper.setText(R.id.current_date, mContext.getString(R.string.format_term, item.lottery.getTerm(),
                item.lottery.getOpenTime_fmt()));

        helper.setText(R.id.current_pool, mContext.getString(R.string.format_pool, item.lottery.getPool()));
        helper.setText(R.id.total_sales, mContext.getString(R.string.format_total_sales, item.lottery.getTotalSales()));


        helper.setText(R.id.tv_ball_1, item.codeNumber.get(0));
        helper.setText(R.id.tv_ball_2, item.codeNumber.get(1));
        helper.setText(R.id.tv_ball_3, item.codeNumber.get(2));
        helper.setText(R.id.tv_ball_4, item.codeNumber.get(3));
        helper.setText(R.id.tv_ball_5, item.codeNumber.get(4));
        helper.setText(R.id.tv_ball_6, item.codeNumber.get(5));
        helper.setText(R.id.tv_ball_7, item.codeNumber.get(6));


        TableLayout tabLayout = helper.getView(R.id.table_container);



        for (int i=0; i < item.details.size(); i++){
            LotteryBaseData.LotteryDetail lotteryDetail = item.details.get(i);


            TableRow tableRow = new TableRow(mContext);

            TextView textView = new TextView(mContext);
            TextView numTV = new TextView(mContext);
            TextView pieceTV = new TextView(mContext);
            TextView sendMoneyTV = new TextView(mContext);
//            TextView baseTV = new TextView(mContext);

            if (i % 2 == 0){
                textView.setText(R.string.base);
            }else{
                textView.setText(R.string.first);
            }

            textView.setLayoutParams(new TableRow.LayoutParams(1));

            numTV.setText(Integer.toString(lotteryDetail.num));
            pieceTV.setText(lotteryDetail.piece);
            sendMoneyTV.setText(lotteryDetail.sendPrize);


            numTV.setGravity(Gravity.CENTER);
            pieceTV.setGravity(Gravity.CENTER);
            sendMoneyTV.setGravity(Gravity.CENTER);


            TableRow.LayoutParams params1= new TableRow.LayoutParams(
                    TableRow.LayoutParams.MATCH_PARENT,TableRow.LayoutParams.MATCH_PARENT, 1.0f);
            TableRow.LayoutParams params2= new TableRow.LayoutParams(
                    TableRow.LayoutParams.MATCH_PARENT,TableRow.LayoutParams.MATCH_PARENT, 1.0f);
            TableRow.LayoutParams params3= new TableRow.LayoutParams(
                    TableRow.LayoutParams.MATCH_PARENT,TableRow.LayoutParams.MATCH_PARENT, 1.0f);

            params1.gravity = Gravity.CENTER;
            params2.gravity = Gravity.CENTER;
            params3.gravity = Gravity.CENTER;


            tableRow.addView(textView);
            tableRow.addView(numTV, params1);
            tableRow.addView(pieceTV, params2);
            tableRow.addView(sendMoneyTV, params3);

            tabLayout.addView(tableRow);


        }


        helper.setOnClickListener(R.id.show_detail, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                helper.getView(R.id.divider).setVisibility(View.GONE);
                helper.getView(R.id.detail_container).setVisibility(View.VISIBLE);
            }
        });


       /* helper.setText(R.id.titleTV, item.fullName);
        helper.setText(R.id.descriptionTV, item.description);

        helper.setText(R.id.startTV, mContext.getString(R.string.format_star, item.stars));
        helper.setText(R.id.forkTV, mContext.getString(R.string.format_fork, item.forks));
        helper.setText(R.id.languageTV, item.language);

        SimpleDraweeView draweeView = helper.getView(R.id.icon_iv);
        draweeView.setImageURI(item.owner.avatorUrl);*/

    }
}