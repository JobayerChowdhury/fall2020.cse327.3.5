# Generated by Django 3.1.3 on 2020-12-24 15:52

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('ivento', '0002_product_image'),
    ]

    operations = [
        migrations.CreateModel(
            name='Contact',
            fields=[
                ('con_id', models.AutoField(primary_key=True, serialize=False)),
                ('name', models.CharField(max_length=50)),
                ('email', models.CharField(default='', max_length=70)),
                ('phone', models.CharField(default='', max_length=70)),
                ('location', models.CharField(default='', max_length=50)),
                ('edate', models.DateField()),
            ],
        ),
    ]
