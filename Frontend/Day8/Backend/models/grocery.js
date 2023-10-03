const db = require('../utils/database');

module.exports = class Grocery {
  constructor(id, item, price) {
    this.id = id;
    this.item = item;
    this.price = price;
  }

  static fetchAll() {
    return db.execute('SELECT * FROM groceries');
  }

  static post(item) {
    return db.execute('INSERT INTO groceries (item) VALUES (?)', [item]);
  }

  static update(id, item , price) {
    return db.execute('UPDATE groceries SET item = ? WHERE id = ?', [item, id, price]);
  }

  static delete(id) {
    return db.execute('DELETE FROM groceries WHERE id = ?', [id]);
  }
};