--------------------------| CREATE__TABLE:dms_ref_visibility_level |--------------------------
create table dms_ref_visibility_level(
  codelevl  number(4)                           not null,
  labllevl  varchar2(30 char)                   not null
);
comment on column dms_ref_visibility_level.codelevl is 'Code';
comment on column dms_ref_visibility_level.labllevl is 'Label';
create unique index pk_ref_visibility_level on dms_ref_visibility_level(codelevl) tablespace dms_ix;
alter table dms_ref_visibility_level add (
    constraint pk_ref_visibility_level
    primary key (codelevl)
    using index pk_ref_visibility_level
    enable validate
);
--------------------------| END__TABLE:dms_ref_visibility_level |---------------------------------
--------------------------| CREATE__TABLE:dms_ref_type_node |---------------------------------
create table dms_ref_type_node(
  codtypno  varchar2(1 char)                    not null,
  labtypno  varchar2(30 char)                   not null
);
comment on column dms_ref_type_node.codtypno is 'Code type node';
comment on column dms_ref_type_node.labtypno is 'Label type node';
create unique index pk_ref_type_node on dms_ref_type_node(codtypno) tablespace dms_ix;
alter table dms_ref_type_node add (
    constraint pk_ref_type_node
    primary key (codtypno)
    using index pk_ref_type_node
    enable validate
);
--------------------------| END__TABLE:dms_ref_type_node |---------------------------------
--------------------------| CREATE__TABLE:dms_ref_type_metadata |-----------------------------
create table dms_ref_type_metadata(
    codtypmd  varchar2(1 char)                    not null,
    labtypmd  varchar2(30 char)                   not null
);
comment on column dms_ref_type_metadata.codtypmd is 'Code type Metadata';
comment on column dms_ref_type_metadata.labtypmd is 'Label type Metadata';
create unique index pk_dms_ref_type_metadata on dms_ref_type_metadata (codtypmd) tablespace dms_ix;
alter table dms_ref_type_metadata add (
    constraint pk_dms_ref_type_metadata
    primary key (codtypmd)
    using index pk_dms_ref_type_metadata
    enable validate
);
--------------------------| END__TABLE:dms_ref_type_metadata |---------------------------------
--------------------------| CREATE__TABLE:dms_ref_type_annotation |---------------------------
create table dms_ref_type_annotation(
  codtypan  varchar2(2 char)                          not null,
  labtypan  varchar2(100 char),
  css_clas  varchar2(50 char)
);
comment on column dms_ref_type_annotation.codtypan is 'Code type annotation';
comment on column dms_ref_type_annotation.labtypan is 'Label type annotation';
create unique index pk_dms_ref_type_annotation on dms_ref_type_annotation(codtypan)tablespace dms_ix;
alter table dms_ref_type_annotation add (
  constraint pk_dms_ref_type_annotation
  primary key(codtypan)
  using index pk_dms_ref_type_annotation
  enable validate
); 
--------------------------| END__TABLE:dms_ref_type_annotation |---------------------------------
--------------------------| CREATE__TABLE:dms_ref_nature_type_doc |---------------------------
create table dms_ref_nature_type_doc(
    codenatu  varchar2(5 char)                    not null,
    labenatu  varchar2(30 char)                   not null
);
comment on column dms_ref_nature_type_doc.codenatu is 'Code nature document';
comment on column dms_ref_nature_type_doc.labenatu is 'Label nature document';
create unique index pk_dms_ref_nature_type_doc on dms_ref_nature_type_doc(codenatu)tablespace dms_ix;
alter table dms_ref_nature_type_doc add (
    constraint pk_dms_ref_nature_type_doc
    primary key (codenatu)
    using index pk_dms_ref_nature_type_doc
    enable validate
);
--------------------------| END__TABLE:dms_ref_nature_type_doc |---------------------------------
--------------------------| CREATE__TABLE:dms_ref_type_doc |----------------------------------
create table dms_ref_type_doc(
    idetypdo  number(12)                          not null,
    labtypdo  varchar2(60 char),
    codenatu  varchar2(5 char)                    not null,
    disporde  number(3),
    flagacti  varchar2(2 char),
    is__defa  varchar2(2 char),
    createby  number(10)                   not null,
    createon  date                                default sysdate               not null,
    editedby  number(10),
    editedon  date
);
comment on column dms_ref_type_doc.idetypdo is 'Type document';
comment on column dms_ref_type_doc.labtypdo is 'Label Type document';
create unique index pk_dms_ref_type_doc on dms_ref_type_doc(idetypdo) tablespace dms_ix;
alter table dms_ref_type_doc add (
    constraint pk_dms_ref_type_doc
    primary key(idetypdo)
    using index pk_dms_ref_type_doc
    enable validate
);
alter table dms_ref_type_doc add (
    constraint fk_type_nature 
    foreign key (codenatu) 
    references dms_ref_nature_type_doc (codenatu)
    enable validate,
    constraint fk_dms_ref_type_doc_createby
    foreign key (createby) 
    references opf_user (idenpost)
    enable validate,
    constraint fk_dms_ref_type_doc_editedby
    foreign key (editedby) 
    references opf_user (idenpost)
    enable validate
);
--------------------------| END__TABLE:dms_ref_type_doc |---------------------------------
--------------------------| CREATE__TABLE:dms_ref_type_doc_metadata |-------------------------
create table dms_ref_type_doc_metadata(
    idetypdo  number(12)                          not null,
    idenmeta  number(10),
    codemeta  varchar2(5 char),
    lablmeta  varchar2(40 char),
    codtypmd  varchar2(1 char),
    defavale  varchar2(60 char),
    nom_tabl  varchar2(40 char),
    key_colo  varchar2(40 char),
    labecolo  varchar2(40 char),
    ordemeta  number(3),
    weigmeta  number(3),
    mandator  number(1)                           default 0                     not null,
    sql_list  varchar2(600 char)
);
create unique index pk_dms_ref_type_doc_metadata on dms_ref_type_doc_metadata(idetypdo, idenmeta) tablespace dms_ix;
alter table dms_ref_type_doc_metadata add (
    constraint pk_dms_ref_type_doc_metadata
    primary key(idetypdo, idenmeta)
    using index pk_dms_ref_type_doc_metadata
    enable validate
);
alter table dms_ref_type_doc_metadata add (
    constraint fk_dms_ref_type_idetypdo
    foreign key (idetypdo) 
    references dms_ref_type_doc (idetypdo)
    enable validate,
    constraint fk_dms_ref_type_caract 
    foreign key (codtypmd) 
    references dms_ref_type_metadata (codtypmd)
    enable validate
);
--------------------------| END__TABLE:dms_ref_type_doc_metadata |---------------------------------
--------------------------| CREATE__TABLE:dms_ref_key_word_type_doc |-------------------------
create table dms_ref_key_word_type_doc(
    iden_tag  number(4)                           not null,
    idetypdo  number(12)                          not null,
    key_word  varchar2(50 char)
);
comment on column dms_ref_key_word_type_doc.idetypdo is 'Identifiant type document';
comment on column dms_ref_key_word_type_doc.key_word is 'Key word Text';
create unique index pk_dms_refe_type_doc_bin on dms_ref_key_word_type_doc(iden_tag)tablespace dms_ix;
alter table dms_ref_key_word_type_doc add (
    constraint pk_dms_refe_type_doc_bin
    primary key(iden_tag)
    using index pk_dms_refe_type_doc_bin
    enable validate
);
create index pk_dms_ref_key_word_type_doc on dms_ref_key_word_type_doc(idetypdo)tablespace dms_ix;
alter table dms_ref_key_word_type_doc add (
    constraint pk_dms_ref_key_word_type_doc 
    foreign key (idetypdo) 
    references dms_ref_type_doc (idetypdo)
    enable validate
);
--------------------------| END__TABLE:dms_ref_key_word_type_doc |---------------------------------
--------------------------| CREATE__TABLE:dms_ref_metadata |----------------------------------

create table dms_ref_metadata(
    idenmeta  number(10),
    codemeta  varchar2(5 char),
    lablmeta  varchar2(40 char),
    codtypmd  varchar2(1  char),
    defavale  varchar2(60 char),
    nom_tabl  varchar2(40 char),
    key_colo  varchar2(40 char),
    labecolo  varchar2(40 char),
    ordemeta  number(3),
    weigmeta  number(3),
    mandator  number(1)             default 0 not null,
    sql_list  varchar2(600 char)
);
comment on column dms_ref_metadata.codemeta is 'Code Metadata';
comment on column dms_ref_metadata.lablmeta is 'Label Metadata';
comment on column dms_ref_metadata.codtypmd is 'Code type metadata';
comment on column dms_ref_metadata.defavale is 'Default value';
comment on column dms_ref_metadata.nom_tabl is 'Table ou vue for technique data';
comment on column dms_ref_metadata.key_colo is 'Key Column of list';
comment on column dms_ref_metadata.labecolo is 'Label Column of list';
comment on column dms_ref_metadata.ordemeta is 'Ordre';
comment on column dms_ref_metadata.weigmeta is 'Weight';
comment on column dms_ref_metadata.mandator is '1 if the metadata is mandatory and 0 if not?';
comment on column dms_ref_metadata.sql_list is 'Sql to execute if the case of type List';
create unique index pk_dms_ref_metadata on dms_ref_metadata(idenmeta)tablespace dms_ix;
alter table dms_ref_metadata add (
    constraint pk_dms_ref_metadata
    primary key(idenmeta)
    using index pk_dms_ref_metadata
    enable validate
);
alter table dms_ref_metadata add (
    constraint fk_dms_type_caract 
    foreign key (codtypmd) 
    references dms_ref_type_metadata (codtypmd)
    enable validate
);
--------------------------| END__TABLE:dms_ref_metadata |---------------------------------
--------------------------| CREATE__TABLE:dms_ref_domaine |-----------------------------------
create table dms_ref_domaine(
    codedoma  varchar2(2 char)                           not null,
    labldoma  varchar2(50 char),
    createby  number(10)                   not null,
    createon  date                                default sysdate               not null,
    editedby  number(10),
    editedon  date
);
comment on column dms_ref_domaine.codedoma is 'Code domaine';
comment on column dms_ref_domaine.labldoma is 'Lable domaine';
create unique index pk_dms_domain_ref on dms_ref_domaine (codedoma) tablespace dms_ix;
alter table dms_ref_domaine add (
    constraint pk_dms_domain_ref
    primary key (codedoma)
    using index pk_dms_domain_ref
    enable validate
);
alter table dms_ref_domaine add (
    constraint fk_dms_ref_domaine_createby
    foreign key (createby) 
    references opf_user (idenpost)
    enable validate,
    constraint fk_dms_ref_domaine_editedby
    foreign key (editedby) 
    references opf_user (idenpost)
    enable validate
); 
--------------------------| END__TABLE:dms_ref_domaine |---------------------------------
--------------------------| CREATE__TABLE:dms_ref_dynamique |---------------------------------
create table dms_ref_dynamique(
  idenrefe  number(10)                          not null,
  codedoma  varchar2(2 char),
  iderefpa  number(10),
  initrefe  varchar2(5 char),
  desirefe  varchar2(60 char),
  sourrefe  varchar2(50 char),
  key_colu  varchar2(20 char),
  lablcolu  varchar2(20 char),
  condwher  varchar2(200 char),
  ordrrefe  number(5),
  gardenti  number(1),
  key_nive  varchar2(100 char),
  keyparni  varchar2(100 char),
  paranive  varchar2(100 char),
  selecolu  varchar2(100 char),
  createby  number(10)  not null,
  createon  date                                default sysdate               not null,
  editedby  number(10),
  editedon  date
);
comment on column dms_ref_dynamique.idenrefe is 'Identification';
comment on column dms_ref_dynamique.codedoma is 'Code domaine';
comment on column dms_ref_dynamique.iderefpa is 'Identification parent';
comment on column dms_ref_dynamique.initrefe is 'Prefix';
comment on column dms_ref_dynamique.desirefe is 'Designation';
comment on column dms_ref_dynamique.sourrefe is 'Data Source';
comment on column dms_ref_dynamique.key_colu is 'Key Column';
comment on column dms_ref_dynamique.lablcolu is 'Lable';
comment on column dms_ref_dynamique.condwher is 'Condition to extraction data';
create unique index pk_dms_referentiel_dyn on dms_ref_dynamique (idenrefe) tablespace dms_ix;
create unique index ui_dms_ref_dynamique_initrefe on dms_ref_dynamique(initrefe) tablespace dms_ix;
alter table dms_ref_dynamique add (
    constraint pk_dms_referentiel_dyn
    primary key(idenrefe)
    using index pk_dms_referentiel_dyn
    enable validate
);
alter table dms_ref_dynamique add (
    constraint fk_dms_ref_dynamique_codedoma 
    foreign key (codedoma) 
    references dms_ref_domaine (codedoma)
    enable validate,
    constraint fk_dms_ref_dynamique_iderefpa 
    foreign key (iderefpa) 
    references dms_ref_dynamique (idenrefe)
    enable validate,
    constraint fk_dms_ref_dynamique_createby
    foreign key (createby) 
    references opf_user (idenpost)
    enable validate,
    constraint fk_dms_ref_dynamique_editedby
    foreign key (editedby) 
    references opf_user (idenpost)
    enable validate
);
--------------------------| END__TABLE:dms_ref_dynamique |---------------------------------
--------------------------| CREATE__TABLE:dms_structure |-------------------------------------

create table dms_structure(
  idenstru  number(12)                          not null,
  initstru  varchar2(2 char),
  struname  varchar2(60 char),
  descstru  varchar2(600 char),
  createby  number(10)   not null,
  createon  date                                default sysdate               not null,
  editedby  number(10),
  editedon  date
);
comment on column dms_structure.idenstru is 'Identification';
comment on column dms_structure.initstru is 'Prefix';
comment on column dms_structure.descstru is 'Description';
create unique index pk_dms_structure on dms_structure(idenstru) tablespace dms_ix;
create unique index uni_dms_structure on dms_structure(initstru) tablespace dms_ix;
alter table dms_structure add (
    constraint pk_dms_structure
    primary key(idenstru)
    using index pk_dms_structure
    enable validate
);
alter table dms_structure add (
    constraint fk_dms_structure_createby
    foreign key (createby) 
    references opf_user (idenpost)
    enable validate,
    constraint fk_dms_structure_editedby
    foreign key (editedby) 
    references opf_user (idenpost)
    enable validate
);
--------------------------| END__TABLE:dms_structure |---------------------------------
--------------------------| CREATE__TABLE:dms_structure_node |--------------------------------
create table dms_structure_node(
    idennode  number(5)                           not null,
    idenstru  number(5)                           not null,
    idenodpa  number(5),
    desinode  varchar2(80 char),
    ordrnode  number(2),
    codtypno  varchar2(1 char)                    default 'S'                   not null,
    idenrefe  number(10),
    initrefe  varchar2(5 char),
    desirefe  varchar2(60 char),
    sourrefe  varchar2(50 char),
    key_colu  varchar2(20 char),
    lablcolu  varchar2(20 char),
    condwher  varchar2(200 char),
    gardenti  number(1)                           default 0                     not null,
    codedoma  varchar2(2 char),
    createby  number(10)     not null,
    createon  date           not null,
    editedby  number(10),
    editedon  date
);
comment on column dms_structure_node.idennode is 'Identification';
comment on column dms_structure_node.idenstru is 'Identification of the structure';
comment on column dms_structure_node.idenodpa is 'Identification node parent';
comment on column dms_structure_node.desinode is 'Designation of the node';
comment on column dms_structure_node.ordrnode is 'Ordre of node';
comment on column dms_structure_node.codtypno is 'Type Node (S: Static, D: Dynamic)';
comment on column dms_structure_node.codedoma is 'Code domain';
create unique index pk_dms_structure_node on dms_structure_node(idennode)tablespace dms_ix;
alter table dms_structure_node add (
    constraint pk_dms_structure_node
    primary key(idennode)
    using index pk_dms_structure_node
    enable validate
);
create index ix_dms_structure_node1 on dms_structure_node(idenrefe, idenstru)tablespace dms_ix;
create index ix_dms_structure_node2 on dms_structure_node(idenrefe)tablespace dms_ix;
alter table dms_structure_node add (
    constraint fk_dms_structure_node_idenstru
    foreign key (idenstru) 
    references dms_structure (idenstru)
    enable validate,
    constraint fk_dms_structure_node_parent 
    foreign key (idenodpa) 
    references dms_structure_node (idennode)
    enable validate,
    constraint fk_dms_structure_node_codtypno
    foreign key (codtypno) 
    references dms_ref_type_node (codtypno)
    enable validate,
    constraint fk_dms_structure_node_idenrefe
    foreign key (idenrefe) 
    references dms_ref_dynamique (idenrefe)
    enable validate,
    constraint fk_dms_structure_node_createby
    foreign key (createby) 
    references opf_user (idenpost)
    enable validate,
    constraint fk_dms_structure_node_editedby
    foreign key (editedby) 
    references opf_user (idenpost)
    enable validate
);
--------------------------| END__TABLE:dms_structure_node |---------------------------------
--------------------------| CREATE__TABLE:dms_document |--------------------------------------
create table dms_document(
    idendocu  number(25)         	not null,
    binadocu blob
);
comment on column dms_document.idendocu is 'Identification of document';
comment on column dms_document.binadocu is 'Binary document';
create unique index pk_dms_document on dms_document (idendocu) tablespace dms_ix;
alter table dms_document add (
  constraint pk_dms_document
  primary key(idendocu)
  using index pk_dms_document
  enable validate
); 
--------------------------| END__TABLE:dms_document |---------------------------------
--------------------------| CREATE__TABLE:dms_information_doc |-------------------------------
create table dms_information_doc(
    idendocu  number(25)         	not null,
    key_node  varchar2(100 char),
    idenstru  number(12),
    extedocu  varchar2(10 char),
    desidocu  varchar2(120 char)	not null,
    sourdocu  varchar2(100 char),
    authdocu  varchar2(100 char),
    refedocu  varchar2(60 char),
    receveon  date,
    versdocu  varchar2(30 char),
    summdocu  varchar2(4000 char),
    sizedocu  number(20),
    filetype  varchar2(200 char),
    pagecoun  number(6),
    typingon  date,
    typingby  varchar2(30 char),
    rank__on  date,
    rank__by  varchar2(30 char),
    tagsdocu  varchar2(60 char),
    visileve  number(2)      	    default 0	not null,
    pathdoss  varchar2(300 char),
    statdocu  varchar2(2 char),
    datestat  date,
    codeinte  number(5),
    idenpoli  number(20),
    codeassu  number(12),
    exersini  number(4),
    numesini  number(6),
    numepoli  number(15),
    destdocu  varchar2(100 char),
    createby  number(10) not null,
    createon  date              	default sysdate	not null,
    editedby  number(10),
    editedon  date
);

comment on column dms_information_doc.idendocu is 'Identification of document';
comment on column dms_information_doc.key_node is 'Cl� de la structure d''archive';
comment on column dms_information_doc.extedocu is 'Extension du document';
comment on column dms_information_doc.desidocu is 'D�signation document';
comment on column dms_information_doc.idenstru is 'Identification classe archive';
comment on column dms_information_doc.sourdocu is 'Source document';
comment on column dms_information_doc.authdocu is 'Auteur document';
comment on column dms_information_doc.refedocu is 'Reference document';
comment on column dms_information_doc.receveon is 'Date reception document';
comment on column dms_information_doc.versdocu is 'Version document';
comment on column dms_information_doc.summdocu is 'Resum� document';
comment on column dms_information_doc.pagecoun is 'Nombre page document';
comment on column dms_information_doc.typingon is 'Date Typage du document';
comment on column dms_information_doc.rank__on is 'Date Classification du document';
comment on column dms_information_doc.tagsdocu is 'Mots cl�s document';
create unique index pk_dms_information_doc on dms_information_doc (idendocu) tablespace dms_ix;
alter table dms_information_doc add (
    constraint pk_dms_information_doc
    primary key(idendocu)
    using index pk_dms_information_doc
    enable validate
);
alter table dms_information_doc add (
    constraint fk_information_doc_idendocu
    foreign key (idendocu) 
    references dms_document (idendocu)
    enable validate,
    constraint fk_information_doc_idenstru
    foreign key (idenstru) 
    references dms_structure (idenstru)
    enable validate,
    constraint fk_dms_information_do_createby
    foreign key (createby) 
    references opf_user (idenpost)
    enable validate,
    constraint fk_dms_information_do_editedby
    foreign key (editedby) 
    references opf_user (idenpost)
    enable validate
);
--------------------------| END__TABLE:dms_information_doc |---------------------------------
--------------------------| CREATE__TABLE:dms_annotation_doc |--------------------------------
create table dms_annotation_doc(
    idenanno  number(12)                          not null,
    idendocu  number(12)                          not null,
    codtypan  varchar2(2 char),
    textanno  varchar2(800 char),
    createby  number(10)                   not null,
    createon  date                                default sysdate               not null,
    editedby  number(10),
    editedon  date
);
comment on column dms_annotation_doc.idenanno is 'Identification of annotation';
comment on column dms_annotation_doc.idendocu is 'Identification of document';
comment on column dms_annotation_doc.codtypan is 'Type annotation ';
comment on column dms_annotation_doc.textanno is 'Texte annotation';
create unique index pk_dms_annotation_doc on dms_annotation_doc (idenanno) tablespace dms_ix;
alter table dms_annotation_doc add (
    constraint pk_dms_annotation_doc
    primary key(idenanno)
    using index pk_dms_annotation_doc
    enable validate
);
alter table dms_annotation_doc add (
    constraint fk_annotation_doc_idendocu
    foreign key (idendocu) 
    references dms_information_doc (idendocu)
    enable validate,
    constraint fk_dms_annotation_doc_codtypan
    foreign key (codtypan) 
    references dms_ref_type_annotation (codtypan)
    enable validate,
    constraint fk_dms_annotation_doc_createby
    foreign key (createby) 
    references opf_user (idenpost)
    enable validate,
    constraint fk_dms_annotation_doc_editedby
    foreign key (editedby) 
    references opf_user (idenpost)
    enable validate
);
--------------------------| END__TABLE:dms_information_doc |---------------------------------
--------------------------| CREATE__TABLE:dms_metadata_doc |----------------------------------

create table dms_metadata_doc(
  idendocu  number(25)                          not null,
  idetypdo  number(12)                          not null,
  idenmeta  number(10)                          not null,
  valemeta  varchar2(400 char),
  ordemeta  number(3),
  weigmeta  number(3),
  createby  number(10)                   not null,
  createon  date                                default sysdate               not null,
  editedby  number(10),
  editedon  date
);
comment on column dms_metadata_doc.idendocu is 'Identification document';
comment on column dms_metadata_doc.idetypdo is 'Identification type document';
comment on column dms_metadata_doc.idenmeta is 'Metadata Code';
comment on column dms_metadata_doc.valemeta is 'Metadata Value';
create unique index pk_dms_metadata_doc on dms_metadata_doc(idendocu, idetypdo, idenmeta) tablespace dms_ix;
alter table dms_metadata_doc add (
    constraint pk_dms_metadata_doc
    primary key(idendocu, idetypdo, idenmeta)
    using index pk_dms_metadata_doc
    enable validate
);
alter table dms_metadata_doc add (
    constraint fk_metadata_doc_idendocu
    foreign key (idendocu) 
    references dms_information_doc (idendocu)
    enable validate,
    constraint fk_metadata_doc_codemeta
    foreign key (idenmeta) 
    references dms_ref_metadata (idenmeta)
    enable validate,
    constraint fk_metadata_doc_idetypdo
    foreign key (idetypdo) 
    references dms_ref_type_doc(idetypdo)
    enable validate,
    constraint fk_dms_metadata_doc_createby
    foreign key (createby) 
    references opf_user (idenpost)
    enable validate,
    constraint fk_dms_metadata_doc_editedby
    foreign key (editedby) 
    references opf_user (idenpost)
    enable validate
);
--------------------------| END__TABLE:dms_metadata_doc |---------------------------------
--------------------------| CREATE__TABLE:dms_type_doc |--------------------------------------
create table dms_type_doc(
    idendocu  number(25)                          not null,
    idetypdo  number(12)                          not null,
    typingon  date                                default sysdate               not null
);
comment on column dms_type_doc.idendocu is 'Iendification document';
comment on column dms_type_doc.idetypdo is 'Iendification type document';
create unique index pk_dms_type_doc on dms_type_doc(idendocu, idetypdo)tablespace dms_ix;
alter table dms_type_doc add (
    constraint pk_dms_type_doc
    primary key (idendocu, idetypdo)
    using index pk_dms_type_doc
    enable validate
);
alter table dms_type_doc add (
    constraint fk_type_doc_idendocu
    foreign key (idendocu) 
    references dms_information_doc (idendocu)
    enable validate,
    constraint fk_type_doc_idetypdo
    foreign key (idetypdo) 
    references dms_ref_type_doc(idetypdo)
    enable validate
);
--------------------------| END__TABLE:dms_type_doc |---------------------------------
--------------------------| CREATE__TABLE:dms_keyword_docu |----------------------------------
create table dms_keyword_docu(
    idekeywo  number(25)                          not null,
    idendocu  number(25)                          not null,
    key_word  varchar2(50 char),
    createby  number(10)                          not null,
    createon  date                                default sysdate               not null,
    editedby  number(10),
    editedon  date
);
comment on column dms_keyword_docu.idekeywo is 'Identifiant ref document';
comment on column dms_keyword_docu.idendocu is 'Identifiant document';
comment on column dms_keyword_docu.key_word is 'Keyword value';
create unique index pk_dms_keyword_docu on dms_keyword_docu (idekeywo) tablespace dms_ix;
alter table dms_keyword_docu add (
    constraint pk_dms_keyword_docu
    primary key(idekeywo)
    using index pk_dms_keyword_docu
    enable validate
);
alter table dms_keyword_docu add (
    constraint fk_keyword_docu_idendocu
    foreign key (idendocu) 
    references dms_information_doc (idendocu)
    enable validate,
    constraint fk_dms_keyword_docu_createby
    foreign key (createby) 
    references opf_user (idenpost)
    enable validate,
    constraint fk_dms_keyword_docu_editedby
    foreign key (editedby) 
    references opf_user (idenpost)
    enable validate
);
--------------------------| END__TABLE:dms_keyword_docu |---------------------------------
--------------------------| CREATE__TABLE:dms_operation_doc |----------------------------------
create table dms_operation_doc
(
  idenoper  number(25)                          not null,
  idendocu  number(25)                          not null,
  codeoper  number(25),
  ordeoper  number(3),
  createby  number(10)                          not null,
  createon  date                                default sysdate               not null
);
comment on column dms_operation_doc.idenoper is 'Identification d operation';
comment on column dms_operation_doc.idendocu is 'Identification document';
comment on column dms_operation_doc.codeoper is 'Type d operation';
create unique index pk_dms_operation_doc on dms_operation_doc
(idendocu, idenoper, codeoper)
logging
tablespace dms_ix;
alter table dms_operation_doc add (
  constraint pk_dms_operation_doc
  primary key
  (idendocu, idenoper, codeoper)
  using index pk_dms_operation_doc
  enable validate);
alter table dms_operation_doc add (
  constraint fk_operation_doc_codeoper 
  foreign key (idenoper) 
  references dms_ref_operation (idenoper)
  enable validate);
--------------------------| END__TABLE:dms_operation_doc |---------------------------------
--------------------------| CREATE__TABLE:dms_ref_operation |----------------------------------
create table dms_ref_operation
(
  idenoper  number(10),
  codeoper  varchar2(5 char),
  labloper  varchar2(40 char),
  nom_tabl  varchar2(40 char),
  key_colo  varchar2(40 char),
  labecolo  varchar2(40 char),
  ordeoper  number(3),
  sql_list  varchar2(600 char)
);
comment on column dms_ref_operation.codeoper is 'Code OPERATION';
comment on column dms_ref_operation.labloper is 'Label OPERATION';
comment on column dms_ref_operation.nom_tabl is 'Table ou vue for technique data';
comment on column dms_ref_operation.key_colo is 'Key Column of list';
comment on column dms_ref_operation.labecolo is 'Label Column of list';
comment on column dms_ref_operation.ordeoper is 'Ordre';
comment on column dms_ref_operation.sql_list is 'Sql to execute if the case of type List';
create unique index pk_dms_ref_operation on dms_ref_operation
(idenoper)
logging
tablespace dms_ix;
alter table dms_ref_operation add (
  constraint pk_dms_ref_operation
  primary key
  (idenoper)
  using index pk_dms_ref_operation
  enable validate);
--------------------------| END__TABLE:dms_ref_operation |---------------------------------




