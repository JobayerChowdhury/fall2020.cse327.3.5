# Generated by Django 3.1.3 on 2020-12-30 02:49

from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('ivento', '0004_orders'),
    ]

    operations = [
        migrations.RenameField(
            model_name='orders',
            old_name='items',
            new_name='items_json',
        ),
        migrations.RemoveField(
            model_name='orders',
            name='zip_code',
        ),
    ]
