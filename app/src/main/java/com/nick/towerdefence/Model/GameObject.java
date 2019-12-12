package com.nick.towerdefence.Model;
import android.graphics.RectF;

public class GameObject {
    protected float x, y;
    protected int maxHitPoints;
    protected int currentHitPoints;
    protected float hitPointPercentage;
    protected float rotation = 0.0f;
    protected int damage;

    protected boolean isDamaged;
    protected int rateOfFire;

    protected boolean canFire;

    protected RectF bRect = new RectF();

    public GameObject(float x, float y, int HP, float radius, int ROF, int damage)
    {
        this.x = x;
        this.y = y;
        this.maxHitPoints = HP;
        this.currentHitPoints = HP;
        this.rateOfFire = ROF;
        this.damage = damage;
    }

    public void takeDamage(int damage)
    {
        // Reduces current hitpoints of entity (turret/enemy)
        currentHitPoints -= damage;
        this.isDamaged = true;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public boolean getCanFire()
    {
        return this.canFire;
    }

}
