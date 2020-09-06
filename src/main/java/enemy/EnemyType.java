package enemy;

import enemy.types.*;

public enum EnemyType {

    DRAGON(new Dragon()),
    HOBGOBLIN(new Hobgoblin()),
    MIND_FLAYER(new MindFlayer()),
    SKELETON(new Skeleton()),
    WRAITH(new Wraith());

    private Enemy instance;

    EnemyType(Enemy instance) {
        this.instance = instance;
    }

    public Enemy getInstance() {
        return instance;
    }

}
