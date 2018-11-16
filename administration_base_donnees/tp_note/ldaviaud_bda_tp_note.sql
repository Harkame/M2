-- Louis Daviaud

CREATE OR REPLACE PACKAGE TpCC AS
  PROCEDURE DataTable(p_owner_name IN VARCHAR2, p_table_name IN VARCHAR2); --InformationsStockageTable
  PROCEDURE DataTableAndIndex(p_owner_name IN VARCHAR2, p_table_name IN VARCHAR2); --InformationsStockTableIndex
  PROCEDURE CacheBlocks(p_user_name IN VARCHAR2, p_object_type IN VARCHAR2); -- blocsCache
END TpCC;
/

-- SELECT on dba_segments with owner and segment_name, add condition on segment_type = 'TABLE'
-- EXCEPTION : If no data found (user_name or table_name invalid)
CREATE OR REPLACE PACKAGE BODY TpCC AS
  PROCEDURE DataTable(p_owner_name IN VARCHAR2, p_table_name IN VARCHAR2) IS
    CURSOR c IS SELECT segment_name, segment_type, tablespace_name, extents, blocks, ROUND((bytes /1000000), 2) as bytes
    FROM dba_segments
    WHERE owner = p_owner_name
    AND segment_name = p_table_name
    AND segment_type = 'TABLE';

    cursor_size NUMBER := 0;

    BEGIN
      dbms_output.put_line(rpad('segment_name',15)||rpad('segment_type',15)||rpad('tablespace_name',20)||rpad('extents',15)||rpad('blocks',10)||rpad('size (mo)',10));
      dbms_output.put_line('---------------------------------------------------------------------------------------------------');
      FOR t IN c LOOP
        dbms_output.put_line(rpad(t.segment_name,15)||rpad(t.segment_type,15)||rpad(t.tablespace_name,20)||rpad(t.extents,15)||rpad(t.blocks,10)||rpad(t.bytes,10));

        cursor_size := cursor_size + 1;
      END LOOP;

      IF cursor_size = 0 THEN
        raise no_data_found;
      END IF;

      EXCEPTION
        WHEN no_data_found THEN
          raise_application_error(-20000, 'No data found, please check user_name and table_name');
    END;

  -- Same as precedent PROCEDURE, add SELECT with dba_indexes
  -- SELECT all segment with owner, table name and segment_type = type
  -- UNION
  -- SELECT all segment with owner, join dba_indexes (index only)
  -- EXCEPTION : If no data found (user_name or table_name invalid)
  PROCEDURE DataTableAndIndex(p_owner_name IN VARCHAR2, p_table_name IN VARCHAR2) IS
    CURSOR c IS SELECT s.segment_name, s.segment_type, s.tablespace_name, s.extents, s.blocks, ROUND((s.bytes/1000000), 2) as bytes
    FROM dba_segments s
    WHERE owner = p_owner_name
    AND segment_name = p_table_name
    AND segment_type = 'TABLE'
    UNION
    SELECT s.segment_name, s.segment_type, s.tablespace_name, s.extents, s.blocks, ROUND((s.bytes/1000000), 2) as bytes
    FROM dba_segments s, dba_indexes i
    WHERE s.segment_name = i.index_name
    AND s.owner = p_owner_name
    AND i.table_name = p_table_name;

    cursor_size NUMBER := 0;

    BEGIN
      dbms_output.put_line(rpad('segment_name',20)||rpad('segment_type',15)||rpad('tablespace_name',20)||rpad('extents',15)||rpad('blocks',10)||rpad('size (mo)',10));
      dbms_output.put_line('--------------------------------------------------------------------------------------------------------');
      FOR t IN c LOOP
        dbms_output.put_line(rpad(t.segment_name,20)||rpad(t.segment_type,15)||rpad(t.tablespace_name,20)||rpad(t.extents,15)||rpad(t.blocks,10)||rpad(t.bytes,10));

        cursor_size := cursor_size + 1;
      END LOOP;

      IF cursor_size = 0 THEN
        raise no_data_found;
      END IF;

      EXCEPTION
        WHEN no_data_found THEN
          raise_application_error(-20000, 'No data found, please check user_name and table_name');
    END;

  PROCEDURE CacheBlocks(p_user_name IN VARCHAR2, p_object_type IN VARCHAR2) IS
    CURSOR c IS SELECT object_name, object_type, block# as block, class# as class, b.status
    FROM dba_objects o, v$bh b
    WHERE owner = p_user_name
    AND object_type = p_object_type
    AND o.data_object_id = b.objd
    GROUP BY object_name, object_type, block#, class#, b.status;

    cursor_size NUMBER := 0;

    BEGIN
      dbms_output.put_line(rpad('object_name',15)||rpad('object_type',15)||rpad('block',10)||rpad('class',10)||rpad('status',10));
      dbms_output.put_line('--------------------------------------------------------');
      FOR t IN c LOOP
        dbms_output.put_line(rpad(t.object_name,15)||rpad(t.object_type,15)||rpad(t.block,10)||rpad(t.class,10)||rpad(t.status,10));

        cursor_size := cursor_size + 1;
      END LOOP;

      IF cursor_size = 0 THEN
        raise no_data_found;
      END IF;

      EXCEPTION
        WHEN no_data_found THEN
          raise_application_error(-20000, 'No data found, please check user_name or object_type');
    END;
END TpCC;
/

SET serveroutput ON size 30000;
SET linesize 150;

VARIABLE user_name_1 VARCHAR2(20);
VARIABLE user_name_2 VARCHAR2(20);
VARIABLE fake_user_name VARCHAR2(20);

VARIABLE table_name VARCHAR2(20);
VARIABLE fake_table_name VARCHAR2(20);

VARIABLE object_type VARCHAR2(20)
VARIABLE fake_object_type VARCHAR2(20)

EXEC :user_name_1 := 'ISA'
EXEC :user_name_2 := 'IMOUGENOT'
EXEC :fake_user_name := 'TOTO'

EXEC :table_name := 'COMMUNE'
EXEC :fake_table_name := 'TITI'

EXEC :object_type := 'INDEX'
EXEC :fake_object_type := 'TUTU'

-- PLEASE UNCOMMENT PROCEDURE CALL

--QUESTION 1

--EXEC TpCC.DataTable(:user_name_1, :table_name);

--EXCEPTION
--EXEC TpCC.DataTable(:fake_user_name, :table_name);
--EXEC TpCC.DataTable(:user_name_1, :fake_table_name);

--QUESTION 2

--EXEC TpCC.DataTableAndIndex(:user_name_1, :table_name);

--EXCEPTION
--EXEC TpCC.DataTableAndIndex(:fake_user_name, :table_name);
--EXEC TpCC.DataTableAndIndex(:user_name_1, :fake_table_name);

--QUESTION 3
EXEC TpCC.CacheBlocks(:user_name_2, :object_type);

--EXCEPTION
--EXEC TpCC.CacheBlocks(:fake_user_name, :object_type);
--EXEC TpCC.CacheBlocks(:user_name_2, :fake_object_type);

//
