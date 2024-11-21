db = db.getSiblingDB("naezuo"); // naezuo 데이터베이스로 전환

db.createUser({
    user: "mongo_root",
    pwd: "mongo_password",
    roles: [
        { role: "readWrite", db: "naezuo" }
    ]
});