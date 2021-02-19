package com.example.mylab;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;

    public class MainActivity extends AppCompatActivity {
        // Идентификатор уведомления
        private static final int NOTIFY_ID = 101;

        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            createNotificationChannel();
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        private void createNotificationChannel() {

                CharSequence name = "test-channel";
                String description = "test-channel";
                int importance = NotificationManager.IMPORTANCE_DEFAULT;
                NotificationChannel channel = new NotificationChannel("test-channel", name, importance);
                channel.setDescription(description);

                NotificationManager notificationManager = getSystemService(NotificationManager.class);
                notificationManager.createNotificationChannel(channel);
        }

        public void sendActionNotification(View view) {
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);

            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "test-channel")
                    .setTicker("Пришла посылка!")
                    .setContentTitle("Новое сообщение")
                    .setContentText("Это я, почтальон Печкин. Принес для вас посылку")
                    .setSmallIcon(R.drawable.ic_baseline_pets_24).setContentIntent(pIntent)
                    .addAction(R.drawable.ic_menu_gallery, "Открыть", pIntent)
                    .addAction(R.drawable.ic_menu_manage, "Отказаться", pIntent)
                    .addAction(R.drawable.ic_menu_slideshow, "Другой вариант", pIntent);

            notificationManager.notify(1, builder.build());
        }

        public void sendBigTextStyleNotification(View view) {
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);

            NotificationCompat.Builder builder;
            builder = new NotificationCompat.Builder(this, "test-channel")
                    .setTicker("Пришла посылка!")
                    .setContentTitle("Новое сообщение")
                    .setContentText("Это я, почтальон Печкин. Принес для вас посылку. Только я вам ее не отдам. Потому что у вас документов нету.")
                    .setSmallIcon(R.drawable.ic_baseline_pets_24).setContentIntent(pIntent)
                    .setStyle(new NotificationCompat.BigTextStyle());


            notificationManager.notify(1, builder.build());
        }


        public void sendBigPictureStyleNotification(View view) {
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);

            NotificationCompat.Builder builder;
            builder = new NotificationCompat.Builder(this, "test-channel")
                    .setTicker("Пришла посылка!")
                    .setContentText("Уведомление с большой картинкой")
                    .setSmallIcon(R.drawable.ic_baseline_pets_24)
                    .addAction(R.drawable.ic_menu_gallery, "Запустить активность", pIntent)
                    .setStyle(new NotificationCompat.BigPictureStyle()
                            .bigPicture(BitmapFactory.decodeResource(getResources(), R.drawable.open)));

            notificationManager.notify(1, builder.build());
        }

        public void sendInboxStyleNotification(View view) {
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);

            NotificationCompat.Builder builder;
            builder = new NotificationCompat.Builder(this, "test-channel")
                    .setTicker("Пришла посылка!")
                    .setContentTitle("Уведомление в стиле Inbox")
                    .setContentText("Inbox Style notification!!")
                    .setSmallIcon(R.drawable.ic_baseline_pets_24)
                    .addAction(R.drawable.ic_menu_gallery, "Запустить активность", pIntent)
                    .setStyle(new NotificationCompat.InboxStyle()
                        .addLine("Первое сообщение")
                        .addLine("Второе сообщение")
                        .addLine("Третье сообщение")
                        .addLine("Четвертое сообщение")
                        .setSummaryText("+2 more"));

            notificationManager.notify(8, builder.build());
        }
    }


