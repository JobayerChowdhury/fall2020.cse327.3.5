# Generated by Django 3.1.3 on 2021-01-16 15:18

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('ivento', '0010_remove_event_event_date'),
    ]

    operations = [
        migrations.AlterField(
            model_name='orders',
            name='items_Ivento',
            field=models.CharField(max_length=5000),
        ),
    ]
