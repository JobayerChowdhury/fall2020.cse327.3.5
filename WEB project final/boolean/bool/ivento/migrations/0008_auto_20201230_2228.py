# Generated by Django 3.1.3 on 2020-12-30 16:28

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('ivento', '0007_orders_phone'),
    ]

    operations = [
        migrations.RenameField(
            model_name='contact',
            old_name='con_id',
            new_name='msg_id',
        ),
        migrations.RemoveField(
            model_name='contact',
            name='edate',
        ),
        migrations.RemoveField(
            model_name='contact',
            name='location',
        ),
        migrations.AddField(
            model_name='contact',
            name='desc',
            field=models.CharField(default='', max_length=500),
        ),
    ]
