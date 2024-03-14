import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
public class SparkCSVLoader {
    public static void main(String[] args) {
        SparkSession spark = SparkSession
                .builder()
                .master("local[2]")
                .appName("CarCount")
                .getOrCreate();

        Dataset<Row> dataFrame = spark.read()
                .option("header", "true")
                .csv("./src/Automobile.csv")
                .toDF();


        dataFrame.createOrReplaceTempView("car_statistic");
        spark.sql("select * from car_statistic").show();
        spark.sql("select * from car_statistic where origin=\'japan\'").show();
        spark.sql("select * from car_statistic where (select max(Int(horsepower)) from car_statistic)=CAST(horsepower as INT)").show();
        spark.sql("select COUNT(*) from car_statistic where Int(model_year)=80").show();
        spark.sql("select * from car_statistic where (select min(Int(cylinders)) from car_statistic)=CAST(cylinders as INT)").show();
        spark.sql("select model_year, COUNT(model_year) from car_statistic group by model_year order by model_year desc").show();
        spark.sql("select * from car_statistic order by Int(weight) desc limit 10").show();
        spark.sql("select * from car_statistic where (select max(Int(horsepower)) from car_statistic where origin=\'europe\')=CAST(horsepower as INT)").show();
        spark.sql("select AVG(horsepower) as HorsepowerAVG from car_statistic").show();
        spark.sql("select name, model_year from car_statistic where (select AVG(horsepower) as HorsepowerAVG from car_statistic) < Double(horsepower) and origin=\'japan\'").show();
    }
}