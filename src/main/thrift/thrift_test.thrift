namespace java com.mycompany.sertest.thrift


struct SimpleThriftStructParent {
	1: required i64 parentId
}

struct SimpleThriftStruct {
	1: required i64 parentId,
	2: required string message,
        3: required list<string> data,
	4: required i64 someId
}