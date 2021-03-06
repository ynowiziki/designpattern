package observerPattern;

import java.util.ArrayList;

public class WeatherData implements Subject {
    
	private ArrayList<Observer> observers;
	private float temperature;
	private float humidity;
	private float pressure;
	
	public WeatherData () {
		observers = new ArrayList<Observer>();
	}

	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
		
	}

	@Override
	public void deregisterObserver(Observer o) {
		observers.remove(o);		
	}

	@Override
	public void notifyObservers() {
		for (int i=0; i < observers.size(); i++) {
			Observer observer = (Observer) observers.get(i);
			observer.update(temperature, humidity, pressure);			
		}
	}
    
    public void measurementChanged() {
		notifyObservers();
	}
	
	public void setMeasurements(float temp, float humidity, float pressure) {
		this.temperature = temp;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementChanged();
		
	}

}
