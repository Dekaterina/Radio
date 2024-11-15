package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadioTest {
    Radio radio = new Radio();

    @Test
    public void constructorRadioStationTest() {

        Assertions.assertEquals(0, radio.getMinRadioStation());
        Assertions.assertEquals(9, radio.getMaxRadioStation());
        Assertions.assertEquals(0, radio.getCurrentRadioStation());
        Assertions.assertEquals(0, radio.getMinVolume());
        Assertions.assertEquals(100, radio.getMaxVolume());
        Assertions.assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void constructorMaxRadioStationTest() {
        Radio radio = new Radio(45);

        Assertions.assertEquals(0, radio.getMinRadioStation());
        Assertions.assertEquals(45, radio.getMaxRadioStation());
        Assertions.assertEquals(0, radio.getCurrentRadioStation());
        Assertions.assertEquals(0, radio.getMinVolume());
        Assertions.assertEquals(100, radio.getMaxVolume());
        Assertions.assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void upperLimitOfMaxRadioStationConstructorTest() {
        radio.setCurrentRadioStation(46);

        int expected = radio.getMinRadioStation();
        int actual = radio.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void turnUpVolume() { //проверка что работает
        radio.setCurrentVolume(29);
        radio.volumeUp();

        int expected = 30;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void turnUpVolumeMoreMax() {
        radio.setCurrentVolume(101);
        radio.volumeUp();

        int expected = radio.getMaxVolume();
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void turnUpVolumeMax() { //граничное значение 100
        radio.setCurrentVolume(100);
        radio.volumeUp();

        int expected = radio.getMaxVolume();
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void doneOneVolumeFromMax() { //граничное значение 99
        radio.setCurrentVolume(99);
        radio.volumeUp();

        int expected = radio.getMaxVolume();
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void reduceVolume() {  // уменьшение звука на 1
        radio.setCurrentVolume(9);
        radio.volumeDown();

        int expected = 8;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void reduceVolumeLessMin() { //снижение ниже нуль
        radio.setCurrentVolume(0);
        radio.volumeDown();

        int expected = radio.getMinVolume();
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void reduceVolumeIfMin() {
        radio.setCurrentVolume(0);
        radio.volumeDown();

        int expected = radio.getMinVolume();
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void reduceVolumeIfMoreOneMin() {
        radio.setCurrentVolume(1);
        radio.volumeDown();

        int expected = 0;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void setRadioStation() {
        radio.setCurrentRadioStation(9);

        int expected = 9;
        int actual = radio.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void setRadioStationMoreMax() { //граничное 10
        radio.setCurrentRadioStation(10);

        int expected = radio.getMinRadioStation();
        int actual = radio.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void setRadioStationIfLessOneThanMax() {
        radio.setCurrentRadioStation(8);

        int expected = 8;
        int actual = radio.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void setRadioStationLessMin() {
        radio.setCurrentRadioStation(-1);

        int expected = radio.getMinRadioStation();
        int actual = radio.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void setRadioStationIfMoreOneThanMin() {
        radio.setCurrentRadioStation(1);

        int expected = 1;
        int actual = radio.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void nextRadioStation() {
        radio.setCurrentRadioStation(2);
        radio.next();

        int expected = 3;
        int actual = radio.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void nextRadioStationAboveMax() {
        radio.setCurrentRadioStation(9);
        radio.next();

        int expected = radio.getMinRadioStation();
        int actual = radio.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void prevRadioStation() {
        radio.setCurrentRadioStation(8);
        radio.prev();

        int expected = 7;
        int actual = radio.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void prevRadioStationIfLessOneThanMin() {
        radio.setCurrentRadioStation(0);
        radio.prev();

        int expected = radio.getMaxRadioStation();
        int actual = radio.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }
}