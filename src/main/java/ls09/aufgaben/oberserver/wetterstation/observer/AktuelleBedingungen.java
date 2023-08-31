package ls09.aufgaben.oberserver.wetterstation.observer;

import ls09.aufgaben.oberserver.wetterstation.WetterGUI;
import ls09.aufgaben.oberserver.wetterstation.observable.WetterDaten;
import ls09.aufgaben.oberserver.wetterstation.util.Observer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.Range;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RectangleInsets;

import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;

public class AktuelleBedingungen extends JPanel implements Observer {
    private static final String COLUMN_KEY = "Aktuelle Zeit";
    private static final String FEUCHTIGKEIT_ROW_KEY = "Feuchtigkeit (in %)";
    private static final String TEMPERATUR_ROW_KEY = "Temperatur (in °C)";
    private static final String LUFTDRUCK_ROW_KEY = "Luftdruck (in hPa)";
    private static final int MAX_VALUES = 10;
    DefaultCategoryDataset temperaturDataset = new DefaultCategoryDataset();
    DefaultCategoryDataset luftdruckDataset = new DefaultCategoryDataset();
    DefaultCategoryDataset luftfeuchtigkeitDataset = new DefaultCategoryDataset();

    private final WetterDaten daten;

    public AktuelleBedingungen(WetterDaten daten) {
        this.daten = daten;
        daten.addObserver(this);
        initGUI();
    }

    private void initGUI() {
        JFreeChart luftfeuchtigkeitsChart = ChartFactory.createLineChart(
                "Feuchtigkeit",
                COLUMN_KEY, FEUCHTIGKEIT_ROW_KEY,
                luftfeuchtigkeitDataset,
                PlotOrientation.VERTICAL,
                true, true, false);
        styleLineChart(luftfeuchtigkeitsChart);
        JPanel feuchtigkeitsPanel = new ChartPanel(luftfeuchtigkeitsChart);

        JFreeChart luftdruckChart = ChartFactory.createLineChart(
                "Luftdruck",
                COLUMN_KEY, LUFTDRUCK_ROW_KEY,
                luftdruckDataset,
                PlotOrientation.VERTICAL,
                true, true, false);
        luftdruckChart.getCategoryPlot().getRangeAxis().setRange(new Range(950, 1050));
        styleLineChart(luftdruckChart);
        JPanel luftdruckPanel = new ChartPanel(luftdruckChart);


        JFreeChart temperaturChart = ChartFactory.createLineChart(
                "Temperatur",
                COLUMN_KEY, TEMPERATUR_ROW_KEY,
                temperaturDataset,
                PlotOrientation.VERTICAL,
                true, true, false);
        styleLineChart(temperaturChart);
        JPanel temperaturPanel = new ChartPanel(temperaturChart);

        JPanel contentPanel = new JPanel(new GridLayout(3, 0));
        contentPanel.add(feuchtigkeitsPanel);
        contentPanel.add(luftdruckPanel);
        contentPanel.add(temperaturPanel);

        this.setLayout(new BorderLayout());
        this.add(new JLabel("Aktuellebedingungen"), BorderLayout.NORTH);
        this.add(contentPanel, BorderLayout.CENTER);

//        setColors();
    }

    private void styleLineChart(JFreeChart chart) {
//        chart.setBackgroundPaint(WetterGUI.BACKGROUND_COLOR);
//        chart.getPlot().setBackgroundPaint(WetterGUI.BACKGROUND_COLOR);
//        chart.getPlot().setNoDataMessagePaint(WetterGUI.FOREGROUND_COLOR);
//        chart.getLegend().setItemPaint(WetterGUI.FOREGROUND_COLOR);


        StandardChartTheme theme = (StandardChartTheme) org.jfree.chart.StandardChartTheme.createJFreeTheme();

        theme.setTitlePaint(Color.decode("#4572a7"));
//        theme.setExtraLargeFont( new Font(fontName,Font.PLAIN, 16) ); //title
//        theme.setLargeFont( new Font(fontName,Font.BOLD, 15)); //axis-title
//        theme.setRegularFont( new Font(fontName,Font.PLAIN, 11));
        theme.setRangeGridlinePaint(WetterGUI.SECOND_BACKGROUND_COLOR);
        theme.setPlotBackgroundPaint(WetterGUI.BACKGROUND_COLOR);
        theme.setChartBackgroundPaint(WetterGUI.BACKGROUND_COLOR);
        theme.setGridBandPaint(Color.red);
        theme.setAxisOffset(new RectangleInsets(0, 0, 0, 0));
        theme.setBarPainter(new StandardBarPainter());
        theme.setAxisLabelPaint(WetterGUI.FOREGROUND_COLOR);
        theme.apply(chart);
        chart.getCategoryPlot().setOutlineVisible(false);
        chart.getCategoryPlot().getRangeAxis().setAxisLineVisible(false);
        chart.getCategoryPlot().getRangeAxis().setTickMarksVisible(false);
        chart.getCategoryPlot().setRangeGridlineStroke(new BasicStroke());
        chart.getCategoryPlot().getRangeAxis().setTickLabelPaint(Color.decode("#FF0000"));
        chart.getCategoryPlot().getDomainAxis().setTickLabelPaint(Color.decode("#00FF00"));
        chart.setTextAntiAlias(true);
        chart.setAntiAlias(true);
        chart.getCategoryPlot().getRenderer().setSeriesPaint(0, Color.decode("#0000FF"));
    }

    private void updateGUI() {
        String time = LocalTime.now().toString();

        addAktuelleFeuchtigkeit(time, daten.getFeuchtigkeit());
        addAktuelleTemperatur(time, daten.getTemperatur());
        addAktuellenLuftdruck(time, daten.getLuftdruck());

        repaint();
    }

    private void addAktuelleFeuchtigkeit(String time, float feuchtigkeit) {
        if (luftfeuchtigkeitDataset.getColumnCount() >= MAX_VALUES)
            luftfeuchtigkeitDataset.removeColumn(0);
        luftfeuchtigkeitDataset.addValue(feuchtigkeit, FEUCHTIGKEIT_ROW_KEY, time);
        repaint();
    }

    private void addAktuelleTemperatur(String time, float temperatur) {
        if (temperaturDataset.getColumnCount() >= MAX_VALUES)
            temperaturDataset.removeColumn(0);
        temperaturDataset.addValue(temperatur, TEMPERATUR_ROW_KEY, time);
        repaint();
    }

    private void addAktuellenLuftdruck(String time, float luftdruck) {
        if (luftdruckDataset.getColumnCount() >= MAX_VALUES)
            luftdruckDataset.removeColumn(0);
        luftdruckDataset.addValue(luftdruck, LUFTDRUCK_ROW_KEY, time);
        repaint();
    }

    @Override
    public void update() {
        System.out.println(getClass().getName() + "\t|\tneues Wetter:[Feuchtigkeit:" + daten.getFeuchtigkeit() + ",Luftdruck:" + daten.getLuftdruck() + ",Temperatur:" + daten.getTemperatur());
        updateGUI();
    }
}
