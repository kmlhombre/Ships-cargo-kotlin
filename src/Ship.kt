class Ship constructor( ms: String, capacity: Int) {
    val _ms = ms
    val _cap = capacity
    var _cargo = mutableMapOf<String, Pair<Int, Int>>()
    var current = 0

    init {
        println("Ship $_ms was created!")
    }

    fun loading(name: String, amount: Int, single_weight: Int) {
        if(current + amount * single_weight <= _cap) {
            current += amount * single_weight
            if(!_cargo.containsKey(name)) {
                val temp_pair = Pair<Int, Int>(amount, single_weight)
                _cargo[name] = temp_pair
            }
            else {
                if(_cargo[name]?.second != single_weight) {
                    val new_amount: Int
                    new_amount = _cargo[name]?.first?.plus(amount)!!
                    val temp_pair = Pair(new_amount, single_weight)
                    _cargo[name] = temp_pair
                }
                else {
                    val temp_pair = Pair(amount, single_weight)
                    _cargo[name] = temp_pair
                }
            }
        }
        else {
            throw Exception("Cargo is too heavy!")
        }
    }

    fun unloading(name: String, amount: Int) {
        if(_cargo.containsKey(name)) {
            if(_cargo[name]?.first!! >= amount) {
                current -= amount * _cargo[name]?.second!!
                val new_amount: Int
                new_amount = _cargo[name]?.first?.minus(amount)!!
                val temp_pair = Pair<Int, Int>(new_amount, _cargo[name]?.second!!)
                _cargo[name] = temp_pair
            }
            else {
                throw Exception("Amount of cargo is less than unloading aim")
            }
        }
        else {
            throw Exception("Cargo is not on this ship!")
        }
    }

    fun clear() {
        _cargo.clear()
    }

    fun display() {
        for(cargo in _cargo) {
            println(cargo)
        }
    }
}