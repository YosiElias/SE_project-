//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AlertDialog;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.viewpager.widget.ViewPager;
//
//import android.content.Intent;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.ListView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.google.android.gms.tasks.OnFailureListener;
//import com.google.android.gms.tasks.OnSuccessListener;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;
//import com.google.firebase.storage.FileDownloadTask;
//import com.google.firebase.storage.FirebaseStorage;
//import com.google.firebase.storage.ListResult;
//import com.google.firebase.storage.StorageReference;
//
//import java.io.File;
//import java.util.ArrayList;
//
//public class DetailActivity extends AppCompatActivity {
//    // creating object of ViewPager
//    ViewPager mViewPager;
//    ListView reviewListView;
////    private ShapeAdapter adapter;
//
//    // images array
//    final ArrayList<Bitmap>  images = new ArrayList<Bitmap>();
//    final ArrayList<Site>  siteSingalAtList = new ArrayList<Site>();
////            {R.drawable.facebook, R.drawable.pic, R.drawable.pic2, R.drawable.facebook,
////            R.drawable.pic, R.drawable.pic2, R.drawable.facebook, R.drawable.pic};
//
//    // Creating Object of ViewPagerAdapter
//    ViewPagerAdapter mViewPagerAdapter;
//
//    Site selectedShape;
//    String selectedShapeName;
//    private StorageReference myStorage;
//    Button addReviewButton;
//    DatabaseReference siteRef;
//    ArrayList<String> arrayListReviews = new ArrayList<>();
////    ArrayAdapter<String> arr;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState)
//    {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_detail);
//        getSelectedShape();
////        Log.d("reviewListView:***", arrayListReviews.toString());
////        reviewListView = (ListView) findViewById(R.id.reviewList);
////        arr = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayListReviews);
////        reviewListView.setAdapter(arr);
////
////        Log.d("reviewListView:***", arrayListReviews.toString());
////        updateSelectedName();
//        this.updateImageDetailList(selectedShapeName);
//
////        setValues();
//
////        setContentView(R.layout.activity_detail);
//
//        //-------------- first page --------------------
//        // Initializing the ViewPager Object
//        mViewPager = (ViewPager)findViewById(R.id.viewPagerMain);
//
//
//
//        // Initializing the ViewPagerAdapter
//        mViewPagerAdapter = new ViewPagerAdapter(DetailActivity.this, images);
//
//        // Adding the Adapter to the ViewPager
//        mViewPager.setAdapter(mViewPagerAdapter);
//
//
//
////        addReviewButton = (Button) findViewById(R.id.addReviewButton);
//
////        addReviewButton.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                addReview();
////            }
////        });
//
//
//
//
//
//
//    }
//
//    private void getSelectedShape()
//    {
//        Intent previousIntent = getIntent();
//        String parsedStringID = previousIntent.getStringExtra("id");
//        selectedShapeName = previousIntent.getStringExtra("name");
//        Log.d("updateSelectedName", "name="+selectedShapeName);
//        Log.d("updateSelectedName", "id="+parsedStringID);
//        getParsedShape(parsedStringID);
//    }
//
//    private void getParsedShape(String parsedID)
//    {
////        final ArrayList<Site> siteList = new ArrayList<Site>();
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference databaseReference = database.getReference();
//        databaseReference.child("site").orderByChild("id").equalTo(parsedID).addValueEventListener(new ValueEventListener() {
//            /**
//             * This method will be invoked any time the data on the database changes.
//             * Additionally, it will be invoked as soon as we connect the listener, so that we can get an initial snapshot of the data on the database.
//             * @param dataSnapshot
//             */
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                // get all of the children at this level.
//                Iterable<DataSnapshot> children = dataSnapshot.getChildren();
//                siteSingalAtList.clear();
//                Log.d("getParsedShape", "empty:"+siteSingalAtList.size());
//                for (DataSnapshot child : children) {
//                    siteRef = child.getRef();
//                    Site s = child.getValue(Site.class);
//                    siteSingalAtList.add(s);
//                    this.setValues(s);
//                    Log.d("getParsedShape", "siteSingalAtList.size="+siteSingalAtList.size());
//                    assert s != null;
//                }
////                mViewPagerAdapter.notifyDataSetChanged();
//                Log.d("getParsedShape", "siteSingalAtList.size="+siteSingalAtList.size());
//
//            }
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//            }
//            private void setValues(Site s)
//            {
////        Site selectedShape = new Site("2","Herzliya beach", "picture/shvil.jpg", 3, "bla lba", Location.South);
//
//                TextView siteName = (TextView) findViewById(R.id.siteName);
//                TextView siteDetail = (TextView) findViewById(R.id.siteDetail);
////        ImageView iv = (ImageView) findViewById(R.id.mainImage);
//                String detail = "Name: " + s.getName() +
//                        "\n\nArea: " + s.getLocation() +
//                        "\n\nRate: " + s.getRate() + "/10" +
//                        "\n\nDetail: " + s.getDetail();
//                siteName.setText(s.getName());
//                siteDetail.setText(detail);
//
////                siteRef.child("reviews").addValueEventListener(new ValueEventListener() {
////
////                    @Override
////                    public void onDataChange(@NonNull DataSnapshot snapshot) {
////
////                        arrayListReviews.clear();
////
////                        Log.d("reviews", "start");
//
////                        Iterable<DataSnapshot> children = snapshot.getChildren();
////                        for (DataSnapshot child : children) {
////
////                            String review = "Name: " + child.getKey()+ "\n";
////                            review += "Review: " + child.getValue().toString() + "\n";
////                            arrayListReviews.add(review);
////                            Log.d("reviews", review);
////
////
////                        }
////                        arr.notifyDataSetChanged();
////                    }
////
////                    @Override
////                    public void onCancelled(@NonNull DatabaseError error) {
////
////                        Log.d("getParsedShape", "siteSingalAtList.size="+siteSingalAtList.size());
////
////
////                    }
//
//            }
//            //);
//
//
////        setImageList();
//
////        iv.setImageResource(selectedShape.getImage()); //Todo: do all image like this
//        }});
//    //--------------------------------------------
//////        shapeList.clear(); //only for self check of data loading
////        for (Site site:siteList) {
//////            shapeList.add(site);
////            Log.d("firebase0129", site.getRate() +"---"+ site.getName());
////        }
//
//
////
////        for (Site site : MainActivity.shapeList)
////        {
////            if(site.getId().equals(parsedID))
////                return site;
////        }
////        return null;
//}
//
////    private void setValues()
////    {
//////        Site selectedShape = new Site("2","Herzliya beach", "picture/shvil.jpg", 3, "bla lba", Location.South);
////
////        TextView siteName = (TextView) findViewById(R.id.siteName);
////        TextView siteDetail = (TextView) findViewById(R.id.siteDetail);
//////        ImageView iv = (ImageView) findViewById(R.id.mainImage);
////        String detail = "Name: " + selectedShape.getName() +
////                        "\n\nArea: " + selectedShape.getLocation() +
////                        "\n\nRate: " + selectedShape.getRate() + "/10" +
////                        "\n\nDetail: " + selectedShape.getDetail();
////        siteName.setText(selectedShape.getName());
////        siteDetail.setText(detail);
//////        setImageList();
////
//////        iv.setImageResource(selectedShape.getImage()); //Todo: do all image like this
////    }
//
////    private void setImageList() {
////        myStorage = FirebaseStorage.getInstance().getReference().child("picture/"+pictureName).listAll();
////    }
//
//    private void updateImageDetailList(String shapeName) {
////        shapeName = "Jerusalem Forest";
//        Log.d("updateImageDetailList", "shapeName="+shapeName);
//        myStorage = FirebaseStorage.getInstance().getReference().child("picture/"+shapeName);//+shapeName
//        try {
//            final File localTempFile = File.createTempFile("shvil", "jpg");
//
//            myStorage.listAll()
//                    .addOnSuccessListener(new OnSuccessListener<ListResult>() {
//                                              @Override
//                                              public void onSuccess(ListResult listResult) {
//
//                                                  for(StorageReference file:listResult.getItems())
//                                                  {
//                                                      Log.d("firebaseFailed", "file.getName="+file.getName());
//                                                      file.getFile(localTempFile).addOnSuccessListener((new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
//                                                          @Override
//                                                          public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
//                                                              Toast.makeText(DetailActivity.this, "Picture Retrieved",Toast.LENGTH_SHORT).show();
//                                                              Bitmap bitmap = BitmapFactory.decodeFile(localTempFile.getAbsolutePath());
//                                                              images.add(bitmap);
//                                                              Log.d("firebaseFailed", "images.size="+images.size());
////                                        mViewPagerAdapter.notifyDataSetChanged();
//                                                          }
//                                                      })).addOnFailureListener(new OnFailureListener() {
//                                                          @Override
//                                                          public void onFailure(@NonNull Exception e) {
//                                                              Log.e("firebaseFailed", e.getMessage());
//                                                          }
//                                                      });
//                                                  }
//                                              }
//                                          }
//                    ).addOnFailureListener(new OnFailureListener() {
//                        @Override
//                        public void onFailure(@NonNull Exception e) {
//                            Log.e("firebaseFailed", "error!");
//                            Toast.makeText(DetailActivity.this, "Error During Picture Retrieved",Toast.LENGTH_SHORT).show();
//                        }
//                    });
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//
////    private void setimageView(String shapeName) {
////        shapeName = "Jerusalem Forest";
////        myStorage = FirebaseStorage.getInstance().getReference().child("picture/"+shapeName);//+shapeName
////        try {
////            final File localTempFile = File.createTempFile("shvil", "jpg");
////            class myOnSuccess implements OnSuccessListener {
////                public String name;
////                @Override
////                public void onSuccess(Object o) {
////                    {
////                        ListResult listResult = (ListResult) o;
////                        for(StorageReference file:listResult.getItems())
////                        {
////                            Log.d("firebaseFailed", file.getName());
////                            name = file.getName();
////
////                            file.getFile(localTempFile).addOnSuccessListener((new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
////                                @Override
////                                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
////                                    Log.d("firebaseFailed", "in!");
////
////                                    Toast.makeText(DetailActivity.this, "Picture Retrieved",Toast.LENGTH_SHORT).show();
////                                    Bitmap bitmap = BitmapFactory.decodeFile(localTempFile.getAbsolutePath());
////                                    images.add(bitmap);
////                                    Log.d("firebaseFailed", ""+images.size());
////                                }
////                            })).addOnFailureListener(new OnFailureListener() {
////                                @Override
////                                public void onFailure(@NonNull Exception e) {
////                                    Log.e("firebaseFailed", e.getMessage());
////                                }
////                            });
////                        }
////                        mViewPagerAdapter.notifyDataSetChanged();
//////                            Toast.makeText(DetailActivity.this, "Picture Retrieved",Toast.LENGTH_SHORT).show();
//////                            Bitmap bitmap = BitmapFactory.decodeFile(localTempFile.getAbsolutePath());
//////                            ((ImageView) findViewById(R.id.mainImage)).setImageBitmap(bitmap);
////                    }
////                }
////            }
////            myOnSuccess myOS = new myOnSuccess();
////            myStorage.listAll()
////                    .addOnSuccessListener(myOS
//////                            new OnSuccessListener<ListResult>() {
//////                        @Override
//////                        public void onSuccess(ListResult listResult) {
//////
//////                            for(StorageReference file:listResult.getItems())
//////                            {
//////                                Log.d("firebaseFailed", file.getName());
//////
//////                                file.getFile(localTempFile).addOnSuccessListener((new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
//////                                    @Override
//////                                    public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
//////                                        Log.d("firebaseFailed", "in!");
//////
//////                                        Toast.makeText(DetailActivity.this, "Picture Retrieved",Toast.LENGTH_SHORT).show();
//////                                        Bitmap bitmap = BitmapFactory.decodeFile(localTempFile.getAbsolutePath());
//////                                        images.add(bitmap);
//////                                        Log.d("firebaseFailed", ""+images.size());
//////                                    }
//////                                })).addOnFailureListener(new OnFailureListener() {
//////                                    @Override
//////                                    public void onFailure(@NonNull Exception e) {
//////                                        Log.e("firebaseFailed", e.getMessage());
//////                                    }
//////                                });
//////                            }
////////                            Toast.makeText(DetailActivity.this, "Picture Retrieved",Toast.LENGTH_SHORT).show();
////////                            Bitmap bitmap = BitmapFactory.decodeFile(localTempFile.getAbsolutePath());
////////                            ((ImageView) findViewById(R.id.mainImage)).setImageBitmap(bitmap);
//////                        }
//////                    }
////        ).addOnFailureListener(new OnFailureListener() {
////                        @Override
////                        public void onFailure(@NonNull Exception e) {
////                            Log.e("firebaseFailed", "error!");
////                            Toast.makeText(DetailActivity.this, "Error During Picture Retrieved",Toast.LENGTH_SHORT).show();
////                        }
////                    });
////            Log.d("firebaseFailed_out", "going sleep");
////
//////            sleep(100000);
////            Log.d("firebaseFailed_out", myOS.name);
////
////        }catch (Exception e){
////            e.printStackTrace();
////        }
////    }
//
////    private void addReview() {
////
////        AlertDialog.Builder mBuilder = new AlertDialog.Builder(DetailActivity.this);
////        View mView = getLayoutInflater().inflate(R.layout.activity_add_review, null);
////        final EditText mName = (EditText) mView.findViewById(R.id.name);
////        final EditText mReview = (EditText) mView.findViewById(R.id.review);
////        Button mAdd = (Button) mView.findViewById(R.id.add);
////
////        mBuilder.setView(mView);
////        final AlertDialog dialog = mBuilder.create();
////        dialog.show();
////        mAdd.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////
////                String name = mName.getText().toString();
////                String review = mReview.getText().toString();
////
////                if(!name.isEmpty() && !review.isEmpty()){
////
////                    siteRef.child("reviews").child(name).setValue(review);
////
////                    Toast.makeText(DetailActivity.this, "success", Toast.LENGTH_SHORT).show();
////                    dialog.dismiss();
////
////                }else{
////                    Toast.makeText(DetailActivity.this, "try again", Toast.LENGTH_SHORT).show();
////                }
////            }
////        });
////    }
