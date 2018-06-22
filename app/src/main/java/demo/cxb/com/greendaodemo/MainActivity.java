package demo.cxb.com.greendaodemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button mBtnInsert;
    private Button mBtnQuery;
    private Button mBtnUpdate;
    private Button mBtnDelete;
    private TextView mTvResult;

    private BookDao mBookDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        initView();
        initListener();
        doOnCreated();
    }

    private void init() {
        DBManager.getInstance().init(this);
        mBookDao = DBManager.getInstance().getDaoSession().getBookDao();
    }

    private void initView() {
        mBtnInsert = (Button) findViewById(R.id.btn_insert);
        mBtnQuery = (Button) findViewById(R.id.btn_query);
        mBtnUpdate = (Button) findViewById(R.id.btn_update);
        mBtnDelete = (Button) findViewById(R.id.btn_delete);
        mTvResult = (TextView) findViewById(R.id.tv_result);
    }

    private void initListener() {
        mBtnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = new Book(null, "C++", 52.95D, 100, 87.25F, "20");
                mBookDao.insert(book);
                print();
            }
        });
        mBtnQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                print();
            }
        });
        mBtnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = mBookDao.queryBuilder().where(BookDao.Properties.Id.eq(3)).unique();
                if (book != null) {
                    book.price = 88.88F;
                    mBookDao.update(book);
                }
                print();
            }
        });
        mBtnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Book> list = mBookDao.queryBuilder().where(BookDao.Properties.Price.eq(52.95)).list();
                if (list != null && !list.isEmpty()) {
                    mBookDao.delete(list.get(0));
//                    mBookDao.deleteInTx(list);
                }
                print();
            }
        });
    }

    private void doOnCreated() {
        mBtnQuery.performClick();
    }

    private void print() {
        List<Book> list = mBookDao.queryBuilder().list();
        mTvResult.setText("");
        if (list != null && !list.isEmpty()) {
            for (Book book : list) {
                mTvResult.append(book.toString() + "\n");
            }
        }
    }

}
